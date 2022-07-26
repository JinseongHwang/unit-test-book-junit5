package me.study.unittest;

public class ProductRepository {

    public Product getById(int productId) {
        return Product.getRandom();
    }
}
