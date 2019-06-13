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
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Override
    public Set<ProductDiscount> calculateDiscount(final DiscountForm discountForm) {
        final BigDecimal discount = discountForm.getDiscount();
        final Set<ProductForm> productForms = discountForm.getProducts();
        final BigDecimal percent = calculatePercent(discount, productForms);
        return productForms
                .stream()
                .map(productForm -> {
                    final ProductDiscount productDiscount = new ProductDiscount();
                    final Product product = createProduct(percent, productForm, productForm.getPrice());
                    productDiscount.addProduct(product);
                    return productDiscount;
                })
                .collect(Collectors.toSet());
    }

    private Product createProduct(BigDecimal percent, ProductForm productForm, BigDecimal price) {
        final Product product = new Product();
        product.setName(productForm.getName());
        product.setDiscount(percent.multiply(price));
        return product;
    }

    private BigDecimal calculatePercent(final BigDecimal discount, final Set<ProductForm> productForms) {
        final BigDecimal overall = getOverall(productForms);
        return discount.divide(overall, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal getOverall(Set<ProductForm> productForms) {
        return productForms
                    .stream()
                    .map(ProductForm::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
