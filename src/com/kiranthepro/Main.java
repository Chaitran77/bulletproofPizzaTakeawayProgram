package com.kiranthepro;

import java.util.*;

public class Main {

    final static double largePizza = 13.99;
    final static double mediumPizza = 10.99;
    final static double smallPizza = 7.99;
    final static double toppingPrice = 1.25;

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        double pizzaSize = choosePizza(scanner);
        ArrayList<String> pizzaToppings = getToppings(scanner);
        System.out.println(pizzaToppings.size());
        System.out.println(pizzaToppings);
        System.out.println(pizzaSize);

        double price = pizzaSize + (pizzaToppings.size()>2 ? pizzaToppings.size()-2:0 * toppingPrice);

        System.out.println("You have chosen " + String.join(", ", pizzaToppings) + " as your toppings, with a total price of £" + price + ". Please wait while your pizza is prepared...");
    }

    public static ArrayList<String> getToppings(Scanner scanner) {
        ArrayList<String> toppings = new ArrayList<>();
        boolean finished = false;

        while (!finished) {
            String newTopping = addTopping(scanner, toppings);
            if (!newTopping.equals("done")) {
                toppings.add(newTopping);
                System.out.println("Successfully added " + newTopping + "!");
            } else {
                finished = true;
            }
        }
        return toppings;
    }

    public static String addTopping(Scanner scanner, ArrayList toppings) {
        System.out.println("Type what topping you want, just type 'end' if you're done:");
        String input = scanner.next();

        if (!input.equals("end")) {
            if (!checkTopping(toppings, input)) {
                addTopping(scanner, toppings);
            }
            return input;
        }
        return "done";
    }

    public static boolean checkTopping(ArrayList toppings, String toppingInQuestion) {
        ListIterator toppingsIter = toppings.listIterator();

        if (toppingInQuestion.length() <= 20 || toppingInQuestion.matches(".*\\d.*")) {
            for (Object topping:toppings.toArray()) {
                if (toppingInQuestion.equalsIgnoreCase(topping.toString()) || topping.toString().contains(toppingInQuestion)) {
                    System.out.println("You've already added " + topping + ". Please add something else - you can't have too much of a good thing!");
                    return false;
                }
            }
        } else {
            System.out.println("Topping has too long of a name or contains numbers :( Try again: ");
            return false;
        }

        return true;
    }

    public static double choosePizza(Scanner scanner) {
        System.out.println("What size pizza would you like: 'small', 'medium' or 'large'?");
        String pizzaSize = scanner.next();

        if (pizzaSize.equalsIgnoreCase("small")) {
            return smallPizza;
        } else if (pizzaSize.equalsIgnoreCase("medium")) {
            return mediumPizza;
        } else if (pizzaSize.equalsIgnoreCase("large")) {
            return largePizza;
        } else {
            System.out.println("Oh no :( Please type either small, medium or large. Try again:");
            choosePizza(scanner);
        }

        return 0;
    }
}
