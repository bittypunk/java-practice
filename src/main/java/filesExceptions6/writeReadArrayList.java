package filesExceptions6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class writeReadArrayList {
    public static void main(String[] args) throws IOException {

        toDoFileHandling();

        monthsHandling();
    }

    private static void monthsHandling() throws IOException {

        String filename = "months.txt";

        String[] months = {"Jan", "Feb", "Mar"};

        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));

        int listNumber = 1;
        for (String item : months) {
            bufWriter.write(listNumber + "\n");
            listNumber++;
        }

        bufWriter.close();



        //BufferedReader bReader = new BufferedReader(new FileReader(filename));
        //List<String> numberedToDoList = new ArrayList<>();

        //String line = bReader.readLine();

        //while (line != null) {
            //line = bReader.readLine();
        //}
        //System.out.println("Wrote months to file");

    }

    private static void toDoFileHandling() throws IOException {
        String filename = "to_do_list.txt";

        // example to-do list
        List<String> todo = new ArrayList<>();
        todo.add("Water plants");
        todo.add("Pay electricity bill");
        todo.add("Grocery shopping");

        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filename));

        // write the to-do list to the file
        // one item per line, with numbers

        int listNumber = 1;

        for (String item : todo) {
            bufWriter.write("To do item " + listNumber + " is: " + item + "\n");
            listNumber++; // increase the counter
        }

        bufWriter.close();

        System.out.println("Created sample to-do list and wrote to " + filename);

        // read the file and store all of the items in a list
        BufferedReader bReader = new BufferedReader(new FileReader(filename));

        List<String> numberedToDoList = new ArrayList<>();

        String line = bReader.readLine();

        while (line != null) {
            numberedToDoList.add(line);
            line = bReader.readLine();
        }

        System.out.println("Here is your to do list from the file:");
        System.out.println(numberedToDoList);
    }
}
