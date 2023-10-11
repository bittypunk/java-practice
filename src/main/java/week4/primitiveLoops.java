package week4;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.positiveDoubleInput;

public class primitiveLoops {
    public static void main(String[] args) {

        List<Double> speeds = new ArrayList<>();

        int totalHours = 12;

        for (int hour = 0; hour < totalHours; hour++) {
            double speed = positiveDoubleInput("Enter the internet speed for horu " + hour);
            speeds.add(speed);
        }

        System.out.println("All the speeds are:");

        for (int hour = 0; hour < speeds.size(); hour ++) {
            double speed = speeds.get(hour);
            System.out.printf("Hour: %d  Speed %.2f\n", hour, speed);
        }

        // count the number of times speed = 0

        int zeroCount = 0;

        for (double speed: speeds) {
            if (speed == 0) {
                zeroCount++;
            }
        }
        System.out.println("Number of times there was no connection : " + zeroCount);

        // remove all zeroes
        while (speeds.contains(0.0)) {
            speeds.remove(0.0);
        }
    }
}
