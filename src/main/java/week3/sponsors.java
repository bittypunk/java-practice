package week3;

import java.util.Arrays;

public class sponsors {
    public static void main(String[] args) {

        String[] spons = {"ikea", "at&t", "cvs", "3m"};

        for (int i = 0; i < spons.length; i++){

            spons[i] = spons[i].toUpperCase();
        }

        System.out.println(Arrays.toString(spons));
    }
}
