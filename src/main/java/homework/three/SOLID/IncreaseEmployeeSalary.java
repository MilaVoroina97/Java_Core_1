package homework.three.SOLID;

public class IncreaseEmployeeSalary extends Employee implements IncreaseSalary{


    public IncreaseEmployeeSalary(String name, double salary, int age) {
        super(name, salary, age);
    }

    @Override
    public void increaseSalary(double amount) {
        double salary = getSalary() + amount;
        setSalary(salary);
    }
}
