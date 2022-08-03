package me.study.unittest;

public class PriceEngine {

    public double calculateDiscount(Product... product) {
        final double discount = product.length * 0.01d; // 상품 수에 0.01을 곱한다.
        return Math.min(discount, 0.2d); // 하지만 최대 0.2로 제한하고 있다.
    }
}
