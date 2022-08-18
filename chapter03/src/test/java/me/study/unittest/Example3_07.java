package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Example3_07 {

    private final Store store;
    private final Customer sut;

    public Example3_07() {
        this.store = new Store();
        this.store.addInventory(Product.Shampoo, 10);
        this.sut = new Customer();
    }

    @Test
    void Purchase_succeeds_when_enough_inventory() throws Exception {
        final boolean success = sut.purchase(store, Product.Shampoo, 5);
        assertTrue(success);
        assertSame(5, store.getInventory(Product.Shampoo));
    }

    @Test
    void Purchase_fails_when_not_enough_inventory() throws Exception {
        final boolean success = sut.purchase(store, Product.Shampoo, 15);
        assertFalse(success);
        assertSame(10, store.getInventory(Product.Shampoo));
    }
}
