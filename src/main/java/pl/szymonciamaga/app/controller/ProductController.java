package pl.szymonciamaga.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonciamaga.app.dto.ProductDiscountDTO;
import pl.szymonciamaga.app.form.ProductForm;
import pl.szymonciamaga.app.service.ProductService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/discount")
    public ProductDiscountDTO calculateProductDiscount(@RequestBody final ProductForm productForm) {
        return productService.calculateDiscount(productForm);
    }
}
