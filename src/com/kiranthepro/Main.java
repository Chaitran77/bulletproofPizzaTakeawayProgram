package com.kiranthepro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> pizzaToppings = getToppings(scanner);
    }

    public static ArrayList<String> getToppings(Scanner scanner) {
        ArrayList<String> toppings = new ArrayList<>();
        boolean finished = false;

        while (!finished) {
            String newTopping = addTopping(scanner, toppings);
            if (!newTopping.equals("")) {
                toppings.add(newTopping);
            } else {
                finished = true;
            }
        }
        return toppings;
    }

    public static String addTopping(Scanner scanner, ArrayList toppings) {
        System.out.println("Type what topping you want, just hit enter if you're done:");
        String input = scanner.next();

        if (checkForExistingTopping(toppings, input`))) {
            System.out.println("You've already added " + input + ". Please add something else - you can't have too much of a good thing!");
        }
        return scanner.next();
    }

    public static boolean checkForExistingTopping(ArrayList toppings, String toppingInQuestion) {
        for (Object topping:toppings.toArray()) {
            if (toppingInQuestion.equalsIgnoreCase(topping.toString())) {
                return true;
            }
        }
        return false;
    }

    public static int choosePizza(Scanner scanner) {
        System.out.println("What size pizza would you like: 'small', 'medium' or 'large'?");
        String pizzaSize = scanner.next();

        if (pizzaSize.equalsIgnoreCase("small")) {
            return 1;
        } else if (pizzaSize.equalsIgnoreCase("medium")) {
            return 2;
        } else if (pizzaSize.equalsIgnoreCase("large")) {
            return 3;
        } else {
            System.out.println("Oh no :( Please type either small, medium or large. Try again:");
            choosePizza(scanner);
        }

        return 0;
    }
}
