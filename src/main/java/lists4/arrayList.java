package lists4;

import java.util.ArrayList;
import java.util.List;


// all list operations can be used with any list type
public class arrayList {
    public static void main(String[] args) {

        List<String> trees = new ArrayList<>();

        trees.add("Pine");  // adds data to the end
        trees.add("Oak");
        trees.add("Elm");
        trees.add("Aspen");

        trees.add(2, "Palm"); // Add data at index 2, in the middle

        System.out.println("Tree at index 1 is " + trees.get(1)); // get by index

        for (String tree: trees) {
            System.out.println(tree);
        }

        trees.remove("Oak");   // remove by value
        trees.remove(0);   // remove by index

        System.out.println(trees);

        if (trees.contains("Aspen")) {
            System.out.println("Tree List contains Aspen");
        }

        int numberOfTrees = trees.size();     // number of items in the list

        if (trees.isEmpty()) {
            System.out.println("There are no trees");
        }
        else {
            System.out.println("There are " + numberOfTrees + " trees in the list.");
        }
    }
}
