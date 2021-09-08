package com.GroceryStore;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.konsole.English;
import com.GroceryStore.konsole.Spanish;
import com.GroceryStore.konsole.UserInterface;
import com.Util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory = new ArrayList<>();
    private int balance = 500_00;
    private String name;
    public UserInterface ui;

    private void setLanguage() {
        int choice = UserInterface.getInt(1, 2, "1. English\n2. Español", "Invalid number/Número invalido");
        switch (choice) {
            case 1 -> ui = new English(this);
            case 2 -> ui = new Spanish(this);
        }
    }

    public Store(String name) {
        this.name = name;
        setLanguage();
        ui.start();
    }

    public void addToInventory(Product product) {
        if (product.getPrice() > balance) {
            System.out.println("Not enough funds");
            return;
        }
        balance -= product.getPrice();
        inventory.add(product);
    }

    public void addToInventory(String name, int price, String id, String description, int volume, int vu) {
        Drink drink = new Drink(name, price, id, description, volume, vu);
        addToInventory(drink);
    };

    public void addToInventory(String name, int price, String id, String description, int hardness) {
        Fruit fruit = new Fruit(name, price, id, description, hardness);
        addToInventory(fruit);
    };

    public void throwAway(Product product) {
        inventory.remove(product);
    }

    public void purchase(Product product) {
        balance += product.getPrice();
        throwAway(product);
    }

    public String getInventory() {
        String output = "";
        for (Product prod : inventory) {
            output += prod + "\n";
        }
        return output;
    }

    public String getBalance() {return Formatter.getDisplayPrice(balance);}

    public String getName() {return name;}

    public Product getProduct (String id) {
        for (Product product : inventory) {
            if (product.id.equals(id)) {
                return product;
            }
        }
        return null;
    }

}
