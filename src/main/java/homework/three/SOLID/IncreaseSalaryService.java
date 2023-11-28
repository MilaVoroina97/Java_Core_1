package homework.three.SOLID;

public class IncreaseSalaryService {

    private IncreaseSalary increaseSalary;
    public IncreaseSalaryService(IncreaseSalary increaseSalary){
        this.increaseSalary = increaseSalary;
    }

    public void increaseSalary(double amount){
        increaseSalary.increaseSalary(amount);
    }


}
