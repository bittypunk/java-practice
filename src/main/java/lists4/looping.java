package lists4;

import java.util.ArrayList;
import java.util.List;

public class looping {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Tut");
        arrayList.add("MCTC");

        for (String s: arrayList) {
            System.out.println(s);
        }

        for (String s: arrayList) {
            System.out.println(s.toUpperCase());
        }

        for (String s: arrayList){
            System.out.println(s.length());
        }

    }
}
