package seminar.two.caesar.cryptoAnalizator.file;


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
        return null;
    }
}
