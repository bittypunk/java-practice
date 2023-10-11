package week3;

public class runningSchedule {
    public static void main(String[] args) {

        double marathon = 26.2;
        double change = .1;

        double[] miles = new double[30];

        for (int x = 1; x < miles.length; x++){
            for (double y = 1; y < marathon + (marathon * change); y = y + (y * change)){
                miles[x] = y;
                 System.out.println("Week " + x + " run " + y + " miles");
            }
        }

        System.out.println(miles.toString());
/**
        for (int weeks = 1; weeks < 10; weeks++) {
            System.out.printf("\nWeek %d", weeks);
        }
        for (double y = 1; y < 26.2; y = y + (y * .01)) {
            System.out.printf("\n%.2f miles", y);
        }
 */
    }

}
