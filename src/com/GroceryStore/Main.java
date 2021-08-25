package com.GroceryStore;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;

public class Main {
    public static void main(String[] args) {
        Product prod = new Fruit("Apple", 89, "p-001", "Red Apple", 5, true);
        Fruit prod2 = new Fruit("Orange", 5_50, "p-002", "Bag of blood oranges", 4);
        Product prod3 = new Drink("Milk", 4_00 , "d-001", "Whole milk Gallon", 1, "Gal");
        Drink prod4 = new Drink("Orange Juice", 4_99, "d-002", "with pulp", 2 , 5);
        System.out.println(prod);
        System.out.println(prod2);
        System.out.println(prod3);
        System.out.println(prod4);
    }
}
