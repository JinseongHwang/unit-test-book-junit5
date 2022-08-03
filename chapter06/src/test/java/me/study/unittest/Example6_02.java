package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Example6_02 {

    @Test
    void Adding_a_product_to_an_order() throws Exception {
        // Given
        final Product product = new Product("Hand wash");
        final Order sut = new Order();

        // When
        sut.addProduct(product);

        // Then
        assertThat(sut.products().size()).isEqualTo(1);
        assertThat(sut.products().get(0)).isEqualTo(product);
    }
}
