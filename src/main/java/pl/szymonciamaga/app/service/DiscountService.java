package pl.szymonciamaga.app.service;

import pl.szymonciamaga.app.form.DiscountForm;
import pl.szymonciamaga.app.model.ProductDiscount;

import java.util.Set;

public interface DiscountService {

    Set<ProductDiscount> calculateDiscount(final DiscountForm discountForm);

}
