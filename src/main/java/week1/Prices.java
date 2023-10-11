package week1;

import static input.InputUtils.*;

public class Prices {
    public static void main(String[] args) {

        String productName = stringInput("What is the name of the product?");
        double price = doubleInput("What does " + productName + " cost?");
        int quantity = intInput("How many " + productName + " to sell?");

        // Calculate the total price for this quantity of the product
        double totalPrice = price * quantity;

        System.out.println(quantity + " of " + productName +
                " at $" + price + " each costs $" + totalPrice);
        System.out.printf("The total price for %d of %s at $%.2f each costs $%.2f\n",
                quantity, productName, price, totalPrice);
    }
}
