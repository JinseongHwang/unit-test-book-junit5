package me.study.unittest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final List<Product> products = new ArrayList<>();

    public List<Product> products() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
