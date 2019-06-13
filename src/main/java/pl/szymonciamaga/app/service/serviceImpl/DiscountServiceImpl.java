package pl.szymonciamaga.app.service.serviceImpl;

import org.springframework.stereotype.Service;
import pl.szymonciamaga.app.form.DiscountForm;
import pl.szymonciamaga.app.form.ProductForm;
import pl.szymonciamaga.app.model.Product;
import pl.szymonciamaga.app.model.ProductDiscount;
import pl.szymonciamaga.app.service.DiscountService;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Override
    public ProductDiscount calculateDiscount(final DiscountForm discountForm) {
        final BigDecimal discount = discountForm.getDiscount();
        final Set<ProductForm> productForms = discountForm.getProducts();
        ProductDiscount productDiscount = new ProductDiscount();
        BigDecimal left = discount;
        final BigDecimal overall = getOverall(productForms);

        for (ProductForm productForm : productForms) {
            BigDecimal partialDiscount = productForm.getPrice().divide(overall).multiply(discount);
            left = left.subtract(partialDiscount);
            final Product product = createProduct(productForm, partialDiscount);
            productDiscount.addProduct(product);
        }

        final Product product = productDiscount.getProducts().get(productDiscount.getProducts().size()-1);
        product.getDiscount().subtract(left);
        productDiscount.removeProduct(productDiscount.getProducts().size()-1);
        productDiscount.addProduct(product);
        return productDiscount;
    }

    private Product createProduct(ProductForm productForm, BigDecimal partialDiscount) {
        final Product product = new Product();
        product.setName(productForm.getName());
        product.setDiscount(partialDiscount);
        return product;
    }

    private BigDecimal getOverall(Set<ProductForm> productForms) {
        return productForms
                    .stream()
                    .map(ProductForm::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
