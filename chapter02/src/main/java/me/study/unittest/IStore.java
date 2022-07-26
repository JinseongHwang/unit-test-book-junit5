package me.study.unittest;

public interface IStore {

    boolean hasEnoughInventory(Product product, int quantity);
    void removeInventory(Product product, int quantity);
    void addInventory(Product product, int quantity);
    int getInventory(Product product);
}
