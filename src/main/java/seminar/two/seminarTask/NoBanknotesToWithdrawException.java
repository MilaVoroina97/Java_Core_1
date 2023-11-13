package seminar.two.seminarTask;

public class NoBanknotesToWithdrawException extends RuntimeException{

    public NoBanknotesToWithdrawException(int amount){
        super(String.format("Запрашиваемая сумма(%s) не может быть выдана", amount));
    }
}
