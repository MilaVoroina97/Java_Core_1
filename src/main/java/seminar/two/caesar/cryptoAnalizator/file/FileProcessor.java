package seminar.two.caesar.cryptoAnalizator.file;


import seminar.two.caesar.cryptoAnalizator.file.exceptions.FileProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
* Класс файл - процессор , который отвечает за всю бизнес - логику для работы с файлами, в частности
 * это чтение и запись
*/
public class FileProcessor {

    private static final StandardOpenOption[] FILE_WRITE_OPTIONS =
            {StandardOpenOption.CREATE,StandardOpenOption.APPEND};

    /**
     * Метод для чтения файла
     * @param filename  путь к файлу
     * @return строки файла в списке
     * @throws FileProcessingException   бросает исключение, в случае если файл не будет доступен для чтения или
     * в случае слишком большого размера файла
     *
     * @throws InvalidPathException   если путь к файлу будет неверно обработан, то выбросится исключение(это
     * исключение относится к методу Path.of(filename)
     */

    public List<String> readFile(String filename){
        try{

            Path filePath = Path.of(filename);
            return Files.readAllLines(filePath);
        }catch (IOException | InvalidPathException ex){

            throw new FileProcessingException(ex.getMessage(), ex);
        }
    }

    /**
     * Метод записи в файл
     * @param filename   имя файла для записи
     * @param content    строка, которую нужно записать
     * @throws FileProcessingException        исключение при неверной обработки доступа, размера или пути к
     * файлу
     */

    public void appendToFile(String filename, String content){

        try{
            Path filePath = Path.of(filename);
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        }catch (IOException | InvalidPathException ex){

            throw new FileProcessingException(ex.getMessage(),ex);
        }

    }

}
