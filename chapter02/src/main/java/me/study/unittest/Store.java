package me.study.unittest;

import java.util.HashMap;
import java.util.Map;

public class Store implements IStore {

    private final Map<Product, Integer> inventory = new HashMap<>();

    @Override
    public boolean hasEnoughInventory(Product product, int quantity) {
        return getInventory(product) >= quantity;
    }

    @Override
    public void removeInventory(Product product, int quantity) {
        if (!hasEnoughInventory(product, quantity)) {
            throw new IllegalArgumentException("Not enough inventory");
        }
        inventory.merge(product, quantity, (src, val) -> src - val);
    }

    @Override
    public void addInventory(Product product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    @Override
    public int getInventory(Product product) {
        return inventory.get(product);
    }
}
