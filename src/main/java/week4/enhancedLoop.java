package week4;

public class enhancedLoop {
    public static void main(String[] args) {
        int[] numberArray = { 1, 2, 3, 4, 5 };

        // Add up all the numbers in an array
        int sum = 0;
        for (int n : numberArray) {
            sum = sum + n;
        }
        System.out.println("Sum of numbers in numberArray is " + sum);

        // Display all the names in a String array
        String[] names = {"Al", "Bea", "Carl"};
        for (String name : names) {
            System.out.println(name);
        }
    }
}
