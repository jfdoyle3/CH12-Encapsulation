package com.GroceryStore.console;

import com.GroceryStore.Products.Drink;
import com.GroceryStore.Products.Fruit;
import com.GroceryStore.Products.Product;
import com.GroceryStore.Store;

import java.util.Scanner;

public class UI {
    private Store store;
    private static Scanner scanner = new Scanner(System.in);
    private Language lang;

    public UI(Store store) {
        this.store = store;
        setLang();
    }

    private void setLang() {
        int choice = getInt(1, 2, "1. English\n2. Español");
        switch (choice) {
            case 1 -> lang = new English();
            case 2 -> lang = new Spanish();
        }
    }


    public void welcome(String name) {
        System.out.println(lang.WELCOME() + name + "!");
    }

    public static void displayOptions(String prompt, String[] options) {
        System.out.println(prompt);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void start() {
        welcome(store.getName());
        while (true) {
            displayOptions(lang.MENU_PROMPT(), lang.MENU());
            int choice = getInt(1, lang.MENU().length, lang.SELECT_PROMPT());
            handleMenuSelection(choice);
        }
    }

    public int getInt(int min, int max, String prompt) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try{
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(lang.ERROR_MSGS()[1]);
            } catch (Exception err) {
                System.out.println(lang.ERROR_MSGS()[2]);
            }
//            finally {
//                System.out.println("HI there");
//            }
            //code here
        } while (option < min || option > max);
        return option;
    }

    public String getString(String prompt, boolean isRequired) {
        String input;

        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (isRequired && input.length() == 0) {
                System.out.println(lang.ERROR_MSGS()[3]);
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
            case 6 -> setLang();
            default -> System.out.println(lang.ERROR_MSGS()[1]);
        }
    }

    private void addProduct() {
        displayOptions(lang.PRODUCT_PROMPT(), lang.PRODUCT_TYPES());
        int choice = getInt(1, lang.PRODUCT_TYPES().length, lang.SELECT_PROMPT());
        Product newProduct;
        switch (choice) {
            case 1 -> newProduct = getDrinkDetails();
            case 2 -> newProduct = getFruitDetails();
            default -> {
                System.out.println(lang.ERROR_MSGS()[1]);
                newProduct = null;
            }
        }
        store.addToInventory(newProduct);
    }

    private Drink getDrinkDetails() {
        return new Drink(
                getString(lang.PRODUCT_FIELDS()[0], true),
                getInt(1, Integer.MAX_VALUE, lang.PRODUCT_FIELDS()[1]),
                getString(lang.PRODUCT_FIELDS()[2], true),
                getString(lang.PRODUCT_FIELDS()[3], false),
                getInt(1, Integer.MAX_VALUE, lang.DRINK_FIELDS()[0]),
                getInt( 0, Drink.UNITS.length - 1, lang.DRINK_FIELDS()[1])
        );
    }

    private Fruit getFruitDetails(){
        return new Fruit(
                getString ( lang.PRODUCT_FIELDS()[0],true),
                getInt ( Integer.MIN_VALUE,Integer.MAX_VALUE, lang.PRODUCT_FIELDS()[1] ),
                getString ( lang.PRODUCT_FIELDS()[2], true ),
                getString ( lang.PRODUCT_FIELDS()[3], false ),
                getInt ( 1,Integer.MAX_VALUE, lang.FRUIT_FIELDS()[0])
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
        Product prod = selectProduct(lang.SELECT_PROMPT() + " " + lang.CANCEL_PROMPT());
        if (prod == null) {
            System.out.println(lang.ERROR_MSGS()[4]);
            return;
        }
        store.throwAway(prod);
    }

    private void sellProduct() {
        Product prod = selectProduct(lang.SELECT_PROMPT() + " " + lang.CANCEL_PROMPT());
        if (prod == null) {
            System.out.println(lang.ERROR_MSGS()[4]);
            return;
        }
        store.purchase(prod);
    }

}
