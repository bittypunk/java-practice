package objects7;

public class main {
    public static void main(String[] args) {

        pool como = new pool("Como Park", 25);
        pool ymca = new pool("YMCA Downtown", 20);
        pool edina = new pool("Edina", 50);

        double totalDistance = como.distanceForLaps(5);
        System.out.println(totalDistance);

        double edinaTotal = edina.distanceForLaps(12);
        System.out.println(edinaTotal);
        System.out.println(edina);

        System.out.println(ymca);
    }
}
