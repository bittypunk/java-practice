package hashmaps5;

import java.util.HashMap;
import java.util.Map;

import static input.InputUtils.*;

public class snowfall {
    public static void main(String[] args) {
        // create the snowfall map
        Map <String, Double> snowfall = new HashMap<>();

        // adds hard-coded data to the map
        addManualData(snowfall);

        // adds user-inputted data to the map
        addUserData(snowfall);

        // display the entries?
        boolean display = yesNoInput("Would you like to display the entries?");
        if (display) {
            mapDisplay(snowfall);
        }

        // sums up the snowfall and displays the result?
        boolean sumDisplay = yesNoInput("Would you like to sum up the year?");
        if (sumDisplay) {
            totalSnowfall(snowfall);
        }
    }

    private static void mapDisplay(Map<String, Double> snowfall) {
        for (Map.Entry<String, Double> entry : snowfall.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    // add up all the snowfall amounts and display the answer
    private static void totalSnowfall(Map<String, Double> snowfall) {
        double total = 0;

        for (double value : snowfall.values()) {
            total = total + value;
        }

        System.out.println("The total snowfall for the year was " + total + " inches.");
    }


    // ask user for month/snowfall amount and add to hashmap
    private static void addUserData(Map<String, Double> snowfall) {
        boolean newEntry = yesNoInput("Would you like to add an entry?");

        while (newEntry) {
            String month = stringInput("Please enter the month to be added or updated:");
            double snow = positiveDoubleInput("PLease enter the amount of snowfall in inches:");

            if (monthCheck(month, snowfall)) {
                snowfall.put(month, snow);
            } else {
                System.out.println(month + " will not be updated.");
            }

            newEntry = yesNoInput("Would you like to add another entry?");;
        }
    }


    // adds raw data to the list
    private static void addManualData(Map<String, Double> snowfall) {
        snowfall.put("January", 3.6);
        snowfall.put("February", 10.8);
        snowfall.put("January", 4.6); // updates january

        snowfall.put("March", 4.1);
        snowfall.put("April", 0.0);
    }


    // checks if the month already exists, then asks if you would like to update the entry.
    private static boolean monthCheck(String month, Map<String, Double> snowfall) {
        if (snowfall.containsKey(month)) {
            boolean add = yesNoInput("This month already exists, would you like to update the current entry of " + snowfall.get(month) + " inches?");
            if (add) {
                return true;
            }
        }
        return false;
    }
}
