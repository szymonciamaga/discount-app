package pl.szymonciamaga.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@JsonFormat
public class ProductDiscount {

    private Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
