package me.study.unittest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Product {
    Shampoo, Book;

    public static Product getRandom() {
        final List<Product> products = Arrays.asList(values());
        Collections.shuffle(products);
        return products.get(0);
    }
}
