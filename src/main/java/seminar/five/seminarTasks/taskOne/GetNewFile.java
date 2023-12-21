package seminar.five.seminarTasks.taskOne;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * Cоздать пару-тройку текстовых файлов. Для упрощения (чтобы не разбираться с
 * кодировками) внутри файлов следует писать текст только латинскими буквами.
 */

public class GetNewFile {
    public static void main(String[] args) throws IOException {

        Path logfile = Paths.get("logfile.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(logfile, StandardCharsets.UTF_8)){
            writer.write("Привет");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("the-file-name.txt");
        Files.write(file, lines, StandardCharsets.UTF_8);
        Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt"), StandardCharsets.UTF_8))) {
            writer.write("something");
        }
    }
}
