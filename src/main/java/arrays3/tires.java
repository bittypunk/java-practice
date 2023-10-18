package arrays3;

import static input.InputUtils.*;

public class tires {
    public static void main(String[] args) {

        System.out.println("Welcome to the Tire Price Comparison Calculator");

        int tiresToCompare = positiveIntInput("Please enter the number of tires to compare");
        String[] tireReports = new String[tiresToCompare];

        for (int x = 0; x < tiresToCompare; x++ ){
            String report = getTireStats();
            tireReports[x] = report;
        }

        printReportTable(tireReports);
    }

    private static String getTireStats() {
        String type = stringInput("Enter the tire name");
        double price = doubleInput("Enter the price for " + type);
        int miles = positiveIntInput("Enter warranty miles for " + type);

        double pricePerMile = price / miles;
        double pricePer1000Miles = pricePerMile * 1000;

        return String.format("%s costs %.2f, has a %d mile warranty and costs %.2f dollars per miles.", type, price, miles, pricePerMile);
    }

    private static void printReportTable(String[] tireReports) {
        for (int x = 0; x < tireReports.length; x++) {
            System.out.println(tireReports[x]);
        }
    }

}
