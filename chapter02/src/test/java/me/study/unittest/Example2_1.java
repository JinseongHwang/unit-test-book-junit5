package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Example2_1 {

    @Test
    void Purchase_succeeds_when_enough_inventory() throws Exception {
        // Given
        final Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        final Customer customer = new Customer();

        // When
        final boolean success = customer.purchase(store, Product.Shampoo, 5);

        // Then
        assertTrue(success);
        assertSame(5, store.getInventory(Product.Shampoo));
    }

    @Test
    void Purchase_fails_when_not_enough_inventory() throws Exception {
        // Given
        final Store store = new Store();
        store.addInventory(Product.Shampoo, 10);
        final Customer customer = new Customer();

        // When
        final boolean success = customer.purchase(store, Product.Shampoo, 15);

        // Then
        assertFalse(success);
        assertSame(10, store.getInventory(Product.Shampoo));
    }
}
