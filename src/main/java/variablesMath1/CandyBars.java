package variablesMath1;

import static input.InputUtils.intInput;
import static input.InputUtils.positiveIntInput;

public class CandyBars {
    public static void main(String[] args) {
        int candyBars = intInput("How many candybars?");
        // checks number is positive
        int people = positiveIntInput("How many people?");
    }
}
