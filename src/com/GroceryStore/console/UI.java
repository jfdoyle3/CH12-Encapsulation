package com.GroceryStore.console;

import com.GroceryStore.Store;

import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);
    private final static String[] MENU=new String[]{
            "1. add product to inventory",
            "2. throw away a product",
            "3. list products available",
            "4. sell a product",
            "5. quit"
    };

    private final static String[] PRODUCT_TYPES=new String[]{
            "1. Drink",
            "2. Fruit"
    };

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for(String option : options)
            System.out.println(option);
    }

    public static void start(Store store) {
        welcome(store.getName());
        displayOptions("What would you like to do?",MENU);
        int choice = getInt(1, PRODUCT_TYPES.length, "Enter selection between 1 and 5:");
    }

    public static int getInt(int min, int max, String prompt) {
        int option;
        do {
            try {
                System.out.println(prompt);
                String input = scanner.next();
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(e);
                option = max + 1;
            }
        } while (option < min || option > max);
        return option;
    }

    public static void handleMenuSelection(int choice) {
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                throwAwayProduct();
                break;
            case 3:
                displayProducts();
                break;
            case 4:
                sellProducts();
            case 5:
                System.exit(0);
            default:
                System.out.println("invalid number");
        }
    }

    private static void addProduct() {
        displayOptions("What kind of Product?",PRODUCT_TYPES);
    }
}
