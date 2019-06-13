package pl.szymonciamaga.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

@JsonFormat
public class ProductDiscount {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int index) {
        products.remove(index);
    }
}
