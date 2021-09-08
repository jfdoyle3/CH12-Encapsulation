package com.GroceryStore.konsole;

import java.util.Scanner;

public interface UserInterface {
    static Scanner scanner = new Scanner(System.in);
    void start();
    static int getInt(int min, int max, String prompt, String errorMsg) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try{
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(errorMsg);
            }
        } while (option < min || option > max);
        return option;
    };
}
