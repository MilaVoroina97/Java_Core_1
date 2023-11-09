package seminar.two.caesar.cryptoAnalizator.consoleui;


/**
 * Enum - отдельный список для хранения доступных операции
 */

public enum Operation {

    //TODO можно в лямбде-выражении Runnable записать другую логику(функцию) шифрования
    EXIT(0,"exit",() -> System.out.println("Operation 1")),

    ENCRYPTION(1 ,"encrypt file",() -> System.out.println("Operation 2")),

    DECRYPTION(2 ,"decrypt file",() -> System.out.println("Operation 3")),

    BRUTEFORCE(3 ,"try to crack file with bruteforce",() -> System.out.println("Operation 4"));


    private final int number;
    private final String description;

    private final Runnable runnable;

    /**
     * @param number   номер операции, которая вводится пользователем
     * @param description  описание операции
     * @param runnable  то, что будет выполнено при выборе операции
     */

    Operation(int number, String description, Runnable runnable) {
        this.number = number;
        this.description = description;
        this.runnable = runnable;
    }

    public int getNumber(){
        return this.number;
    }

    public String getDescription(){

        return this.description;
    }

    public void run(){
        this.runnable.run();
    }

    /**
     * Метод для проверки доступной операции для пользователей
     * @param  number номер операции, которую должен будет вводить пользователь
     * @return Operation возвращает номер операции, если такова имеется
     */

    public static Operation getByNumber(int number){

        for(Operation operation : values()){
            if(operation.getNumber() == number){
                return operation;
            }
        }
        throw new IllegalStateException("There is not such operation");

    }

}
