package seminar.two.caesar.cryptoAnalizator.file;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/* Файл процесса, который отвечает за всю бизнес - логику для работы с файлами, в частности это чтение и запись
* */
public class FileProcessor {

    private static final StandardOpenOption[] FILE_WRITE_OPTIONS =
            {StandardOpenOption.CREATE,StandardOpenOption.APPEND};

    /** Метод для чтения файла
     * @param filename  путь к файлу
     * @return строки файла в списке
     */

    public List<String> readFile(String filename){
        try{

            Path filePath = Path.of(filename);
            return Files.readAllLines(filePath);
        }catch (IOException ex){

            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
