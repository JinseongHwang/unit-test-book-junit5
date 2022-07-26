package me.study.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Example5_04 {

    @Mock
    IStore storeMock;

    @Test
    void Purchase_succeeds_when_enough_inventory() throws Exception {
        // Given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(false);
        final Customer sut = new Customer();

        // When
        final boolean success = sut.purchase(storeMock, Product.Shampoo, 5);

        // Then
        assertThat(success).isFalse();
        then(storeMock).should(never()).removeInventory(Product.Shampoo, 5);
    }
}
