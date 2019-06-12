package pl.szymonciamaga.app.service.serviceImpl;

import org.springframework.stereotype.Service;
import pl.szymonciamaga.app.form.ProductForm;
import pl.szymonciamaga.app.model.Product;
import pl.szymonciamaga.app.model.ProductDiscount;
import pl.szymonciamaga.app.service.ProductService;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDiscount calculateDiscount(final ProductForm productForm) {
        final BigDecimal discount = productForm.getDiscount();
        final Set<Product> products = productForm.getProducts();





        return null;
    }

}
