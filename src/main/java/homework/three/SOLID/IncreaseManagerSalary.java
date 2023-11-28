package homework.three.SOLID;

public class IncreaseManagerSalary extends Manager implements IncreaseSalary{


    public IncreaseManagerSalary(String name, double salary, int age) {
        super(name, salary, age);
    }

    @Override
    public void increaseSalary(double amount) {

        amount = 0;
        double salary = getSalary() + amount;
        setSalary(salary);
    }
}
