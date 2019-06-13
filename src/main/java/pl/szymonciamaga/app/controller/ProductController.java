package pl.szymonciamaga.app.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonciamaga.app.form.DiscountForm;
import pl.szymonciamaga.app.model.ProductDiscount;
import pl.szymonciamaga.app.service.DiscountService;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Resource
    private DiscountService discountService;

    @GetMapping("/discount")
    public Set<ProductDiscount> getProductsDiscounts(@RequestBody @Validated final DiscountForm discountForm) {
        return discountService.calculateDiscount(discountForm);
    }
}
