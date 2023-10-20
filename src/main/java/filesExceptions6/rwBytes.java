package filesExceptions6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class rwBytes {
    public static void main(String[] args) throws IOException {

        Path helloFilePath = Path.of("hello.txt");
        byte[] bytes = Files.readAllBytes(helloFilePath);
        String allLines = new String(bytes);
        System.out.println("All lines\n" + allLines);
        allLines = allLines.replace("\r", ""); // required on Windows but not mac/linux
        String[] lines = allLines.split("\n");
        System.out.println(Arrays.toString(lines));
    }
}
