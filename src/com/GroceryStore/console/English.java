package com.GroceryStore.console;

public class English implements Language {

    @Override
    public String[] MENU() {
        return new String[] {
                "1. add product to inventory",
                "2. throw away a product",
                "3. list products available",
                "4. sell a product",
                "5. quit",
                "6. change language",
        };
    }

    @Override
    public String[] PRODUCT_TYPES() {
        return new String[] {
                "1. Drink",
                "2. Fruit",
        };
    }

    @Override
    public String WELCOME() {
        return "Welcome to ";
    }

    @Override
    public String MENU_PROMPT() {
        return "What do you want to do?";
    }

    @Override
    public String SELECT_PROMPT() {
        return "Enter selection:";
    }

    @Override
    public String PRODUCT_PROMPT() {
        return "What kind of product?";
    }

    @Override
    public String CANCEL_PROMPT() {
        return "press enter to cancel";
    }

    @Override
    public String[] ERROR_MSGS() {
        return new String[] {
                "OK",
                "Invalid number",
                "general exception",
                "Must enter something",
                "404 - Product not Found"
        };
    }

    @Override
    public String[] PRODUCT_FIELDS() {
        return new String[] {
                "Name:", "price:", "id:", "DescripTion:"
        };
    }

    @Override
    public String[] DRINK_FIELDS() {
        return new String[] {
                "Volume:", "Volume Unit Code:"
        };
    }

    @Override
    public String[] FRUIT_FIELDS() {
        return new String[] {
                "Hadness Level:", "Is organic:"
        };
    }
}
