package seminar.five;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        String src = "c:\\projects\\log.txt";
        FileInputStream input = new FileInputStream(src);
        InputStreamReader reader = new InputStreamReader(input);
        StringBuffer firstBuffer = new StringBuffer();
        File file = new File("c://temp//testFile1.txt");
        Files.createFile(Path.of("c:\\readme.txt"));

    }
}

