package seminar.two.caesar.cryptoAnalizator.file;


import seminar.two.caesar.cryptoAnalizator.file.exceptions.FileProcessingException;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

/**
 * Класс - валидатор для проверки корректности пути к используемому файлу и контролю за тем, в какую папку
 * пользователь записывает файл.
 * Также этот класс проверяет, не содержит ли этот путь какие-то системные папки
 */

public class FilenameValidator {

    /**
     * Список недоступных для сохранения файлов пользователей системных папок
     */
    private static final List<String> FORBIDDEN_FILE_DIR =
            List.of("etc","proc",".bash_profile",".bash_history");

    private static final String SYSTEM_SEPARATOR = System.getProperty("file.separator");

    /**
     * Метод для проверки пути файла для дальнейшей записи
     * @param filename   путь к файлу
     * @throws FileProcessingException   первое исключение выбрасываем в случае указания директории вместо
     * конкретного файла
     * @throws FileProcessingException второе исключение выбрасываем в случае, если файл недоступен для записи
     */

    public void validateForWriting(String filename){

        Path path = validatePath(filename);
        if(Files.exists(path)){
            if(Files.isDirectory(path)){
                throw new FileProcessingException("This is file is a directory. Content cannot be " +
                        "written in directory : " + path);
            }if(!Files.isWritable(path)){
                throw new FileProcessingException("File" + path + "is not accessible for writing");
            }
        }
    }

    /**
     * Метод для проверки пути файла для записи
     * @param filename   путь к файлу
     * @throws FileProcessingException  выбрасывает исключение в случае, если файл недоступен для чтения,
     * если файла не существует и если путь к файлу является директорией
     */

    public void validateForReading(String filename){

        Path path = validatePath(filename);
        if(!Files.exists(path)){

            throw new FileProcessingException("There is not such file : " + path + "for reading");
        }

        if(!Files.isReadable(path)){

            throw new FileProcessingException("This file: " + path + "is not accessible for reading");
        }
        if(Files.isDirectory(path)){

            throw new FileProcessingException("This file" + path + "is a directory. You cannot read directory");
        }

    }


    /**
     * Метод проверки пути к файлу на предмет содержания в этом пути системных папок
     * Также исходя из данного метода, запрещается чтение и запись в системные директории + проверка на корректность
     * написания самого пути
     * @param filename  путь к файлу
     * @throws FileProcessingException  выбрасывает искючение в случае некорретного пути к файлу
     */

    private Path validatePath(String filename){

        // разбиваем путь на кусочки(по разделителю операционной системы) и проверяем в каждом,
        // нет ли там системных файлов

        for(String pathPart : filename.split(System.getProperty(SYSTEM_SEPARATOR))){

            if(FORBIDDEN_FILE_DIR.contains(pathPart)){

                throw new FileProcessingException("Path contains forbidden path: " + pathPart);
            }
        }try{

            return Path.of(filename);

        }catch (InvalidPathException ex){

            throw new FileProcessingException("Invalid path. Reason : " + ex);
        }

    }

}
