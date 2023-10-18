package filesExceptions6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writing {

    public static void main(String[] args) throws IOException {

        // create a new file
        FileWriter writer = new FileWriter("hello.txt");
        // wrap FileWriter in BufferedWriter
        BufferedWriter bufWriter = new BufferedWriter(writer);

        // write some strings
        // line by line. don't forget \n
        bufWriter.write("Hello\n");
        bufWriter.write("Data here\n");
        bufWriter.write("Goodbye\n");

        // ALWAYS CLOSE THE FILE
        bufWriter.close();

        // to access hello.txt again you must create a new BufferedWriter and FileWriter
        // since hello.txt already EXISTS, it will be OVERWRITTEN
        writer = new FileWriter("hello.txt");
        // wrap FileWriter in BufferedWriter
        bufWriter = new BufferedWriter(writer);

        // This will overwrite the previous data
        bufWriter.write("This data\n");
        bufWriter.write("overwrites the first set of data.\n");

        // always close when done writing
        bufWriter.close();

        // to see the latest version of a file,
        // right-click the .txt and select "synchronize"

        // appending a file
        writer = new FileWriter("hello.txt", true);
        // wrap FileWriter in BufferedWriter
        bufWriter = new BufferedWriter(writer);

        // this will be added to the end of the existing data
        bufWriter.write("This data\n");
        bufWriter.write("is appended to the end of the first set of data.\n");

        // close
        bufWriter.close();
    }
}
