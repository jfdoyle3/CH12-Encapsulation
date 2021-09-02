package com.GroceryStore;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.console.UI;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("Cliff's store");
        UI ui = new UI();

        System.out.println(store.getBalance());
        store.addToInventory("Apple", 89, "p-001", "Red Apple", 5);
        store.addToInventory("Orange", 5_50, "p-002", "Bag of blood oranges", 4);
        store.addToInventory("Milk", 4_00 , "d-001", "Whole milk Gallon", 1, 0);
        store.addToInventory("Orange Juice", 4_99, "d-002", "with pulp", 2 , 5);
        store.addToInventory(new Fruit("Dragon Fruit", 5_00, "p_003", "Pink dragon white", 3));
        System.out.println(store.getBalance());
        ui.start(store);
        System.out.println(store.getInventory());
        System.out.println(store.getBalance());
//        boolean resp=UI.getBoolean("Organic?");
//        System.out.println("--->"+resp);
    }
}
