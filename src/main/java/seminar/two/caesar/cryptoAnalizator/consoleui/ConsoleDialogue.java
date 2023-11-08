package seminar.two.caesar.cryptoAnalizator.consoleui;

import seminar.two.caesar.cryptoAnalizator.consoleui.exception.InvalidUserInputException;
import seminar.two.caesar.cryptoAnalizator.crypt.CaesarCoder;
import seminar.two.caesar.cryptoAnalizator.crypt.exception.CaesarAlphabetException;
import seminar.two.caesar.cryptoAnalizator.file.exceptions.FileProcessingException;

import java.util.Scanner;

/**
 * Конечный класс для взаимодействия с пользователем через консоль
 */

public class ConsoleDialogue implements Dialogue{

    private static final String OPERATION_PATTERN = "%d - %s";

    private static final String TRY_AGAIN_COMMAND = "again";
    private final Scanner scanner;

    private final CaesarCoder coder;

    public ConsoleDialogue(){

        this.scanner = new Scanner(System.in);
        this.coder = new CaesarCoder();
    }

    /**
     * Метод - точка входа в программу : печатает меню, запрашивает у пользователя номер операции,
     * выполняет эту операцию.
     */
    @Override
    public void start() {
        showMenu();
        Operation operation = readOperation();
        proccessOperation(operation);

    }

    /**
     * Метод - меню : распечатки в виде меню доступных операций для пользователей
     */
    private void showMenu(){

        System.out.println("Choose next option to continue: ");
        for(Operation operation : Operation.values()){

            String message = String.format(OPERATION_PATTERN,operation.getNumber(),operation.getDescription());
            System.out.println(message);
        }
    }

    /**
     * Метод для получения номера доступной операции от пользователя
     * @return возвращает целочисленный номер операции от 1 до 4, в случае неверного вводо - обрабатывается исключение
     * @throws IllegalStateException при вводе номера несуществующей операции
     * @throws InvalidUserInputException при вводе любого символа, отличного от целого числа
     */
    private Operation readOperation(){

        boolean shouldTryAgain = false;
        do {

            try {
                int option = readInt();
                return Operation.getByNumber(option);
            }catch (IllegalStateException | InvalidUserInputException exception){
                System.out.println("Invalid user input.");
                System.out.println("Reason: " + exception.getMessage());
                System.out.println("Enter 'again' for trying again and something other for exit");
                String input = readString();
                if(TRY_AGAIN_COMMAND.equalsIgnoreCase(input)){
                    shouldTryAgain = true;
                }
            }
        }while (shouldTryAgain);

        return Operation.EXIT;

    }

    private int readInt(){

        String input = scanner.nextLine();
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException ex){
            throw new InvalidUserInputException("You should enter integer number.",ex);
        }
    }

    private void processExit(){System.out.println("Bye!");}

    private String readString(){ return scanner.nextLine();}

    /**
     * Метод выполненя конкретной операции, в зависимости от того, какую выберет пользователь
     */
    private void proccessOperation(Operation operation){
        switch (operation){
            case EXIT:
                processExit();
                break;
            case ENCRYPTION:
                processEncryptionOperation();
        }

    }

    private void processEncryptionOperation(){

        System.out.println("Enter filename which contains original text: ");
        String inputFileName = readString();

        System.out.println("Enter filename which be used for result saving: ");
        String outputFileName = readString();

        System.out.println("Enter key :");
        int key = readInt();

        try{
            coder.encrypt(inputFileName,outputFileName,key);
            System.out.println("Done.");
        }catch (FileProcessingException | CaesarAlphabetException ex){

            System.out.println("Error. Reason: " + ex.getMessage());
            ex.printStackTrace();
        }

    }


}
