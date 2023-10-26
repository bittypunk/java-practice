package objects9;

public class pool {

    // fields / variables
    private String name;
    private double length;

    // constructor
    pool(String name, double length) {
        this.name = name;
        this.length = length;
    }

    // instance methods
    public double distanceForLaps(int laps) {
        return laps = (int) length;
    }

    @Override
    public String toString() {
        return name + " pool is " + length + " meters long.";
    }
}
