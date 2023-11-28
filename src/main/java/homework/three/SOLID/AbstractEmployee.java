package homework.three.SOLID;


public class AbstractEmployee {

    String name;
    private double salary;
    int age;

    public AbstractEmployee(String name,double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }


    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double amount){
        this.salary = amount;
    }

}
