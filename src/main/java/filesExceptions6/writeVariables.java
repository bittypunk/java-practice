package filesExceptions6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeVariables {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("variables.txt");
        BufferedWriter bufWriter = new BufferedWriter(writer);

        int intData = 42;
        double dblData = 987.654;
        String strData = "Java";

        // use the bufferedwriter to write all the data to the file

        bufWriter.write(intData + "\n");
        bufWriter.write(dblData + "\n");
        bufWriter.write(strData + "\n");

        // integers must be converted to strings,
        // otherwise it will write "CAT"
        int data1 = 67;
        int data2 = 65;
        int data3 = 84;

        bufWriter.write(data1);
        bufWriter.write(data2);
        bufWriter.write(data3);

        // the easiest way to convert them to a string
        // is to add a newline character
        bufWriter.write(data1 + "\n");

        // of you can explicitly convert the number to a string with an int method
        bufWriter.write(Integer.toString(data2) + "\n"); // still need newlien

        // can write the newline with a separate method
        bufWriter.write(Integer.toString(data3));
        bufWriter.newLine(); //  \n

        // same approach works for doubles too

        double dblData1 = 234.56;
        double dblData2 = 999.99;

        bufWriter.write(dblData1 + "\n"); // can add \n
        bufWriter.write(Double.toString(dblData2) + "\n"); // or use double.toString

        // close, else all data will be lost!
        bufWriter.close();
    }



}
