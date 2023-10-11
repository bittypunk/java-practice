package week3;

import static input.InputUtils.positiveDoubleInput;
import static input.InputUtils.positiveIntInput;

public class MPGcalculator {
    public static void main(String[] args) {

        // Ask user for the miles driven and the amount of gas used
        double miles = positiveDoubleInput("How many miles did you drive?");
        double gas = positiveDoubleInput("How many gallons of gas did you use?");

        // Call a method to calculate MPG, then display the results
        double MPG = calculate(gas, miles);
        System.out.printf("Your vehicle achieved %.2f miles per gallon.", MPG);
    }

    public static double calculate(double g, double m) {

        // Calculate the mpg
        double MPG = m / g;
        return MPG;
    }
}
