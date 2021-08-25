package com.GroceryStore;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory = new ArrayList<>();
    private int balance = 500_00;
    private String name;

    public Store(String name) {
        this.name = name;
    }


    public void addToInventory(Product product) {
        inventory.add(product);
    }


    public void addToInventory(String name, int price, String id, String description, int volume, String volumeUnit) {
        Drink drink = new Drink(name, price, id, description, volume, volumeUnit);
        addToInventory(drink);
    }


    public void addToInventory(String name, int price, String id, String description, int volume, int volumeUnit) {
        Drink drink = new Drink(name, price, id, description, volume, volumeUnit);
        addToInventory(drink);
    }


    public void addToInventory(String name, int price, String id, String description, int hardness, boolean isOrganic) {
        Fruit fruit = new Fruit(name, price, id, description, hardness, isOrganic);
        addToInventory(fruit);
    }


    public void addToInventory(String name, int price, String id, String description, int hardness) {
        Fruit fruit = new Fruit(name, price, id, description, hardness);
        addToInventory(fruit);
    }
}
