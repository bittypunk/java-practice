package week1;

import static input.InputUtils.positiveDoubleInput;

public class Miles {
    public static void main(String[] args) {
        double miles = positiveDoubleInput("How many miles are between your house and MCTC?");
        double kilometers = miles * 1.6;
        System.out.printf("The distance between your house and MCTC is %.2f kilometers.\n", kilometers);
    }
}
