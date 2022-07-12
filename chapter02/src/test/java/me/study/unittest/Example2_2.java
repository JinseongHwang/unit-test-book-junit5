package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class Example2_2 {

    @Mock
    Store storeMock;

    @Test
    public void Purchase_succeeds_when_enough_inventory() {
        // Given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(true);
        final Customer customer = new Customer();

        // When
        final boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        // Then
        assertTrue(success);
        then(storeMock).should(times(1)).removeInventory(Product.Shampoo, 5);
    }

    @Test
    public void Purchase_fails_when_not_enough_inventory() {
        // Given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(false);
        final Customer customer = new Customer();

        // When
        final boolean success = customer.purchase(storeMock, Product.Shampoo, 5);

        // Then
        assertFalse(success);
        then(storeMock).should(never()).removeInventory(Product.Shampoo, 5);
    }
}
