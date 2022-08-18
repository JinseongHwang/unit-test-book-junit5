package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Example3_08 {

    @Test
    public void Purchase_succeeds_when_enough_inventory() {
        // Given
        final Store store = createStoreWithInventory(Product.Shampoo, 10);
        final Customer sut = createCustomer();

        // When
        final boolean success = sut.purchase(store, Product.Shampoo, 5);

        // Then
        assertTrue(success);
        assertSame(5, store.getInventory(Product.Shampoo));
    }

    @Test
    public void Purchase_fails_when_not_enough_inventory() {
        // Given
        final Store store = createStoreWithInventory(Product.Shampoo, 10);
        final Customer sut = createCustomer();

        // When
        final boolean success = sut.purchase(store, Product.Shampoo, 15);

        // Then
        assertFalse(success);
        assertSame(10, store.getInventory(Product.Shampoo));
    }

    private Store createStoreWithInventory(Product product, int quantity) {
        final Store store = new Store();
        store.addInventory(product, quantity);
        return store;
    }

    private static Customer createCustomer() {
        return new Customer();
    }
}
