package arrays3;

import static input.InputUtils.positiveIntInput;
import static input.InputUtils.stringInput;

public class creditsToGraduate {
    public static void main(String[] args) {

        int earned = positiveIntInput("How many credits have you earned?");
        int needed = positiveIntInput("How many credits do you need to graduate?");

        int graduate = howManyCreditsToGraduate(earned, needed);
        System.out.println("You need " + graduate + " credits to graduate.");

    }

    public static int howManyCreditsToGraduate(int e, int n) {

        int credits = e - n;

        if (credits == 0 || credits < 0){
            System.out.println("Congrats on graduating!");
        }

        return credits;
    }
}
