package filesExceptions6;

import java.io.*;

public class me {
    public static void main(String[] args) throws IOException {

        writeFile();
        readFile();
    }



    private static void writeFile() throws IOException {

        // create a new file
        FileWriter writer = new FileWriter("me.txt");
        BufferedWriter bufWriter = new BufferedWriter(writer);

        // write my name, favorite color, and class code
        bufWriter.write("My name is Tut Wilson\n");
        bufWriter.write("My favorite color is up for debate\n");
        bufWriter.write(2545 + "\n");

        // ALWAYS CLOSE THE FILE
        bufWriter.close();
    }


    private static void readFile() throws IOException {

        FileReader reader = new FileReader("me.txt");
        BufferedReader bufReader = new BufferedReader(reader);

        // Read the first line
        String line = bufReader.readLine();

        // if this line is not null, print it out
        while (line != null) {
            System.out.println(line);
            // then read the next line
            line = bufReader.readLine();
        }

        bufReader.close();
    }
}
