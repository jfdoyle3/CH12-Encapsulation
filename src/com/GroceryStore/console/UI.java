package com.GroceryStore.console;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.Scanner;

//TODO make the ui system loop until it exits

public class UI {
    private Store store;
    private static Scanner scanner = new Scanner(System.in);
    private final static String[] MENU = new String[] {
            "1. add product to inventory",
            "2. throw away a product",
            "3. list products available",
            "4. sell a product",
            "5. quit"
    };
    private final static String[] PRODUCT_TYPES = new String[] {
            "1. Drink",
            "2. Fruit",
    };

    public static void welcome(String name) {
        System.out.println("Welcome to " + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void start(Store store) {
        this.store = store;
        welcome(store.getName());
        displayOptions("What do you want to do?", MENU);
        int choice = getInt(1, 5, "Enter selection between 1 and 5:");
        handleMenuSelection(choice);
    }

    public static int getInt(int min, int max, String prompt) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try{
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println("Invalid number");
            } catch (Exception err) {
                System.out.println("general exception");
            }
//            finally {
//                System.out.println("HI there");
//            }
            //code here
        } while (option < min || option > max);
        return option;
    }

    public static String getString(String prompt, boolean isRequired) {
        String input;

        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println("Must enter something");
                continue;
            }
            break;
        } while (true);

        return input;
    }

    public void handleMenuSelection(int choice) {
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> throwAwayProduct();
            case 3 -> displayProducts();
            case 4 -> sellProduct();
            case 5 -> System.exit(0);
            default -> System.out.println("invalid number received");
        }
    }

    private void addProduct() {
        displayOptions("What kind of product?", PRODUCT_TYPES);
        int choice = getInt(1, PRODUCT_TYPES.length, "enter a number");
        Product newProduct;
        switch (choice) {
            case 1 -> newProduct = getDrinkDetails();
            // TODO: implement the following method use getDrinkDetails as reference
//            case 2 -> newProduct = getFruitDetails();
            default -> {
                System.out.println("error bad type");
                newProduct = null;
            }

        }
        store.addToInventory(newProduct);
    }

    private static Drink getDrinkDetails() {
        return new Drink(
                getString("Drink Name", true),
                getInt(1, Integer.MAX_VALUE, "Price?"),
                getString("Id: ", true),
                getString("Description: ", false),
                getInt(1, Integer.MAX_VALUE, "Volume"),
                getInt( 0, Drink.UNITS.length - 1, "Volume Unit")
        );
    }

    private void displayProducts() {
        System.out.println(store.getInventory());
    }

    private Product selectProduct(String prompt) {
        displayProducts();
        String choice = getString(prompt, false);
        return store.getProduct(choice);
    }


    private void throwAwayProduct() {
        Product prod = selectProduct("Which product id to throw away? press enter to cancel");
        if (prod == null) {
            System.out.println("404 - Product not Found");
            return;
        }
        store.throwAway(prod);
    }

    private void sellProduct() {
        Product prod = selectProduct("Which product id to purchase? press enter to cancel");
        if (prod == null) {
            System.out.println("404 - Product not Found");
            return;
        }
        store.purchase(prod);
    }

}
