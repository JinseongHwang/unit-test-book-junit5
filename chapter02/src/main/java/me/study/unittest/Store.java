package me.study.unittest;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private static final Map<Product, Integer> inventory = new HashMap<>();

    public boolean hasEnoughInventory(Product product, int quantity) {
        return getInventory(product) < quantity;
    }

    public void removeInventory(Product product, int quantity) {
        if (hasEnoughInventory(product, quantity)) {
            throw new IllegalArgumentException("Not enough inventory");
        }
        inventory.merge(product, quantity, (src, val) -> src - val);
    }

    public void addInventory(Product product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    public int getInventory(Product product) {
        return inventory.get(product);
    }

    public static void clearForTest() {
        inventory.clear();
    }
}
