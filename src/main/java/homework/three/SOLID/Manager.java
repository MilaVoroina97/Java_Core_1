package homework.three.SOLID;


public class Manager extends AbstractEmployee{


    public Manager(String name, double salary, int age) {
        super(name, salary, age);
    }


    @Override
    public String toString() {
        return "Manager{" +
                "name='" + super.name + '\'' +
                ", salary=" + super.getSalary() +
                "age =" + super.age +'}';
    }

}
