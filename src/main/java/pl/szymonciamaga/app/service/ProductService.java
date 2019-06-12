package pl.szymonciamaga.app.service;

import pl.szymonciamaga.app.form.ProductForm;
import pl.szymonciamaga.app.model.ProductDiscount;

public interface ProductService {

    ProductDiscount calculateDiscount(final ProductForm productForm);

}
