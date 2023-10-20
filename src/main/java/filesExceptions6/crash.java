package filesExceptions6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class crash {

    public static void main(String[] args) {
        String file = "NAfile.txt";

        // bufReader is originally set to null for the if statement
        BufferedReader bufReader = null;
        try {
            FileReader reader = new FileReader(file);
            bufReader = new BufferedReader(reader);
            String line = bufReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Could not open or read " + file);
            System.out.println(ioe);
        }

        finally {
            // finally will run whether an exception is thrown or not
            // typically used to close resources and tidy up

            // close the reader if it was opened
            if (bufReader != null) {
                try {
                    bufReader.close();
                    System.out.println("Closed BufferedReader");
                } catch (IOException ioe) {
                    System.out.println("Eroor closing BufferedReader " + ioe);
                }
            }
        }

        System.out.println("If the code didn't work, the program didn't crash");
        System.out.println("The program keeps running so we can ask the user " +
                "to create this file, or specify the file location");

    }
}
