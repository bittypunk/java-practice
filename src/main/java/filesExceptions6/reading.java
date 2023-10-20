package filesExceptions6;

import java.io.*;

public class reading {
    public static void main(String[] args) throws IOException {

        // Create a FileReader
        // handles opening and closing the file
        // and reading the characters from the file
        FileReader reader = new FileReader("hello.txt");
        // BufferedReader combines the characters read into whole lines
        BufferedReader butReader = new BufferedReader(reader);

        // Read the first line
        String line = butReader.readLine();

        // if this line is not null, print it out
        while (line != null) {
            System.out.println(line);

            // then read the next line
            line = butReader.readLine();
        }

        butReader.close(); // closes the inner FileReader too

    }
}
