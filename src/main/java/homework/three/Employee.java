package homework.three;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private String name;
    private double salary;
    private int age;


    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void increaseSalary(double amount) {
        salary += amount;
    }

    public void dateComparator(String d1, String d2){


        String pattern = "MM-dd-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        Date firstDate = null;
        Date secondDate = null;

        try {
            firstDate = sdf.parse(d1);
            secondDate = sdf.parse(d2);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        int ret = firstDate.compareTo(secondDate);
        if (ret > 0) {
            System.out.printf("%s is after %s", d1, d2);
        }
        else if (ret < 0) {
            System.out.printf("%s is before %s", d1, d2);
        }
        else {
            System.out.print("Both dates are equal");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                "age =" + age +'}';
    }
}
