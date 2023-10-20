package filesExceptions6;

import static input.InputUtils.stringInput;

public class stringtoInt {

    public static void main(String[] args) {

        String numberString = "5";
        // works cuz numberString can be an Int
        int number = Integer.parseInt(numberString); // number will be 5
        System.out.println(number);

        // throws an exception
        // String can't be turned into a number
        try {
            String catString = "cat";
            int catNumber = Integer.parseInt(catString);
            System.out.println(catNumber);
        } catch (NumberFormatException e) {
            System.out.println("Cat isn't a number!");
        }

        // user input is tested to see if an integer is entered
        String userNumberString = stringInput("Enter an integer number:"); // could be a number, or something else

        try {
            int userNumber = Integer.parseInt(userNumberString);
            System.out.println("You entered a valid integer. Your data is " + userNumber);
        } catch (NumberFormatException e) {
            System.out.println("Error - " + userNumberString + " can't be turned into an integer");
        }
    }
}