package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Example6_01 {

    @Test
    void Discount_of_two_products() throws Exception {
        // Given
        final Product product1 = new Product("Hand wash");
        final Product product2 = new Product("Shampoo");
        final PriceEngine sut = new PriceEngine();

        // When
        final double discount = sut.calculateDiscount(product1, product2);

        // Then
        assertThat(discount).isEqualTo(0.02d);
    }
}
