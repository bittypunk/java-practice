package loops2;

import static input.InputUtils.positiveIntInput;
import static input.InputUtils.stringInput;

public class SquareOfStars {
    public static void main(String[] args) {

        int height = positiveIntInput("How tall would you like your square to be?");
        int length = positiveIntInput("How wide would you like your square to be?");
        String character = stringInput("What character would you like your square to be made of?");

        // nested loop
        // outer loop will create 5 rows
        for (int x = 0 ; x < height ; x++){

            // inner loop puts 5 stars on each line
            for (int y = 0 ; y < length ; y++){
                System.out.print(character);
            }

            // move to the next line
            System.out.println();
        }
    }
}
