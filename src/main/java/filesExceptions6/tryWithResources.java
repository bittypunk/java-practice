package filesExceptions6;

import java.io.*;

public class tryWithResources {

    public static void main(String[] args) {
        // reading errors

        String file = "NA.txt";
        // try to open the file that doesn't exist
        // open the resource as the try block starts

        try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {

            String line = bufReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufReader.readLine();
            }
            // bufferedReader is automatically closed

        } catch (IOException ioe) {
            System.out.println("Couldn't open/read " + file);
            System.out.println(ioe.toString());
            System.out.println("Reader and bufReader are auto clsoed");
        }

        // writing errors
        try (BufferedWriter bufWrite = new BufferedWriter(new FileWriter(file))) {
            bufWrite.write("data\n");
            bufWrite.write("data2\n");

            // bufwrite is auto closed, even if the exception is thrown

        } catch (IOException e) {
            System.out.println("Couldn't open/write to " + file);
            System.out.println(e.toString());
            System.out.println("bufwriter/filewriter were auto closed.0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=0-=");
        }
    }
}
