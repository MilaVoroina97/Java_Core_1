package seminar.two.caesar.cryptoAnalizator.crypt;


import seminar.two.caesar.cryptoAnalizator.file.FileProcessor;
import seminar.two.caesar.cryptoAnalizator.file.FilenameValidator;

import java.util.List;

/**
 * Класс, объединяющий бизнес - логику трех классов CaesarAlphabet, FilenameValidator и FileProcessor
 * ( шифрование текста, проверка файла перед записью / чтением и запись / чтение файла
 */

public class CaesarCoder {

    private CaesarCipher caesarCipher;

    private FilenameValidator validator;

    private FileProcessor fileProcessor;


    // TODO продумать дополнительные интерфейсы и модули для избавления от зависимости к конкретному классу,
    // т.е. чтобы можно было выбирать различную имплементацию в зависимости от ситуации, пример как с List, ArrayList..
    public CaesarCoder(){

        this.caesarCipher = new CaesarCipher(new CaesarAlphabet());
        this.validator = new FilenameValidator();
        this.fileProcessor = new FileProcessor();
    }

    /**
     * Метод, объединяющий логику трех классов : сначала идет проверка файлов на чтение и запись, далее текст в исходном
     * файле читается и шифруется построчно, и уже зашифрованный текст записывается в новый файл
     * @param inputFileName  путь к файлу с исходным текстом
     * @param outputFileName  путь к файлу для записи зашифрованного текста
     * @param key             количество сдвигов по алфавиту для шифрования
     */

    public void encrypt(String inputFileName, String outputFileName, int key){

        validator.validateForReading(inputFileName);
        validator.validateForWriting(outputFileName);

        List<String> sourceLines = fileProcessor.readFile(inputFileName);
        // TODO продумать оптимизацию: построчное чтение или запись файла может оказаться слишком медленной
        for(String line : sourceLines){

            String encryptedLine = caesarCipher.encrypt(line,key);
            fileProcessor.appendToFile(outputFileName,encryptedLine);
        }
    }

    /**
     * Метод, объединяющий логику трех классов : сначала идет проверка файлов на чтение и запись, далее текст в исходном
     * файле читается и шифруется построчно, и уже расшифрованный текст записывается в новый файл
     * @param inputFileName  путь к файлу с исходным текстом
     * @param outputFileName  путь к файлу для записи расшифрованного текста
     * @param key             количество сдвигов по алфавиту для расшифрования
     */

    // TODO сделать лямбды выражения для избавления от дублирущегося кода
    public void decrypt(String inputFileName, String outputFileName, int key){

        validator.validateForReading(inputFileName);
        validator.validateForWriting(outputFileName);

        List<String> sourceLines = fileProcessor.readFile(inputFileName);
        for(String line : sourceLines){

            String encryptedLine = caesarCipher.decrypt(line,key);
            fileProcessor.appendToFile(outputFileName,encryptedLine);
        }
    }
}
