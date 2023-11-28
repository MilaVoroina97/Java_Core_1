package homework.three.SOLID;


public class Employee extends AbstractEmployee{


    public Employee(String name, double salary, int age) {
        super(name, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + super.name + '\'' +
                ", salary=" + super.getSalary() +
                "age =" + super.age +'}';
    }
}
