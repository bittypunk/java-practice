package week1;

import static input.InputUtils.doubleInput;
import static input.InputUtils.positiveDoubleInput;

public class PositiveCheck {
    public static void main(String[] args) {
        double price = doubleInput("What is the price of the item?");
        // checks number is positive
        double length = positiveDoubleInput("How long is the string?");
    }
}
