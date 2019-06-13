package pl.szymonciamaga.app.service.serviceImpl;

import org.springframework.stereotype.Service;
import pl.szymonciamaga.app.form.DiscountForm;
import pl.szymonciamaga.app.form.ProductForm;
import pl.szymonciamaga.app.model.Product;
import pl.szymonciamaga.app.model.ProductDiscount;
import pl.szymonciamaga.app.service.DiscountService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Override
    public ProductDiscount calculateDiscount(final DiscountForm discountForm) {
        final BigDecimal discount = discountForm.getDiscount();
        final Set<ProductForm> productForms = discountForm.getProducts();
        final ProductDiscount productDiscount = new ProductDiscount();
        BigDecimal left = discount;
        final BigDecimal overall = getOverall(productForms);

        for (ProductForm productForm : productForms) {
            BigDecimal partialDiscount = getPartialDiscount(discount, overall, productForm);
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

    private BigDecimal getPartialDiscount(BigDecimal discount, BigDecimal overall, ProductForm productForm) {
        return productForm.getPrice().divide(overall, 2, RoundingMode.HALF_UP).multiply(discount);
    }

    private Product createProduct(final ProductForm productForm, final BigDecimal partialDiscount) {
        final Product product = new Product();
        product.setName(productForm.getName());
        product.setDiscount(partialDiscount);
        return product;
    }

    private BigDecimal getOverall(final Set<ProductForm> productForms) {
        return productForms
                    .stream()
                    .map(ProductForm::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
