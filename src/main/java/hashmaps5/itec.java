package hashmaps5;

import java.util.HashMap;
import java.util.Map;

public class itec {
    public static void main(String[] args) {
        Map<String, String> h = new HashMap<>();

        // codes are keys, names are values
        h.put("1100", "Info Tech Concepts");
        h.put("1110", "Info Tech Skills");
        h.put("1150", "Programming Logic");
        h.put("1250", "Windows");
        h.put("1425", "Data Communications");

        // order of keys isn't in the same order they were added in
        System.out.println(h);

        System.out.println("The value for the key 1150 is " + h.get("1150"));

        // displays null instead of error
        System.out.println("The value for the key 1999 is " + h.get("1999"));

        System.out.println("Does HashMap contain the key 1100? " + h.containsKey("1100"));

        System.out.println("Is this HashMap empty? " + h.isEmpty());

        System.out.println("How many key-value pairs? " + h.size());

        System.out.println("Is there an entry with the value \"Windows\"? " + h.containsValue("Windows"));

        System.out.println("Delete the 1250 key-value pair by key. The value is " + h.remove("1250"));

        System.out.println("Delete a key that doesn't exist, what does this return? " + h.remove("1724")); // null

        for (String classNumber : h.keySet()) {
            // use the key to get each value. Repeat for each key.
            System.out.println("Class Number = " + classNumber + " Class Name = " + h.get(classNumber) );
        }

        System.out.println("\nPrinting out all values using a loop\n");

        for (String value : h.values()) {
            System.out.println(value);
        }

        System.out.println("\nA loop for both keys and values\n");

        for (Map.Entry<String, String> entry: h.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
