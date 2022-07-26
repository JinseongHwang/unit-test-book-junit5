package me.study.unittest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String email;

    public boolean purchase(IStore store, Product product, int quantity) {
        if (!store.hasEnoughInventory(product, quantity)) {
            return false;
        }
        store.removeInventory(product, quantity);
        return true;
    }
}
