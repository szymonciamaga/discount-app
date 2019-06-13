package pl.szymonciamaga.app.service;

import pl.szymonciamaga.app.form.DiscountForm;
import pl.szymonciamaga.app.model.ProductDiscount;

public interface DiscountService {

    ProductDiscount calculateDiscount(final DiscountForm discountForm);

}
