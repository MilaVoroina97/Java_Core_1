package seminar.five.seminarTasks.taskTwo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

/**
 * Написать метод, осуществляющий конкатенацию (объединение) переданных ей в
 * качестве параметров файлов (не важно, в первый допишется второй или во второй
 * первый, или файлы вовсе объединятся в какой-то третий);
 */

public class ConcatFiles {
    public static void main(String[] args) {



    }

    public static void mergeFiles(File file1,File file2) throws IOException {

        List<String> lines1 = Files.readAllLines(Paths.get(file1.getPath()), StandardCharsets.UTF_8),
                lines2 = Files.readAllLines(Paths.get(file2.getPath()),StandardCharsets.UTF_8);

        for(int i = 0; i < lines2.size(); i++){
            if(i < lines1.size())
                lines1.set(i,lines1.get(i) + " " + lines2.get(i));
            else
                lines1.add(lines2.get(i));
        }

        Files.write(Paths.get("mergeFile.txt"),lines1,StandardCharsets.UTF_8,CREATE,WRITE,TRUNCATE_EXISTING);
    }

    public static void mergeFiles2(File file1,File file2) throws IOException {

        List<Path> fileContent = Arrays.asList(Paths.get(file1.getPath()),Paths.get(file2.getPath()));
        Path mergeFile = Paths.get("mergeFile2.txt");
        Charset charset = StandardCharsets.UTF_8;
        for(Path path : fileContent){
            List<String> lines = Files.readAllLines(path,charset);
            Files.write(mergeFile,lines,charset,StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }
    }
}
