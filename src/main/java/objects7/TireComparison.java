package objects7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static input.InputUtils.*;

public class TireComparison  {
    public static void main(String[] args) {

        System.out.println("Tire Price Comparerator Initialized");

        List<Tire> tireReports = new ArrayList<>();

        // do this task when answering yes
        do {
            Tire tire = getTireInfo();
            tireReports.add(tire);
        } while (yesNoInput("Are there more tires to add to the comparerator?"));

        // sort tires
        Collections.sort(tireReports);

        // print tires
        printReportTable(tireReports);
    }

    private static Tire getTireInfo() {
        String name = stringInput("What is the name of the tire?");
        double price = positiveDoubleInput("Enter the price of " + name);
        int mileWarranty = positiveIntInput("Enter the number of miles under warranty");

        return new Tire(name, price, mileWarranty);
    }

    private static void printReportTable(List<Tire> tireReports) {
        for (Tire tire : tireReports) {
            System.out.println(tire);
        }
        System.out.println("The cost of 4 tires is " + (Tire.getPrice() * 4));
    }
}
