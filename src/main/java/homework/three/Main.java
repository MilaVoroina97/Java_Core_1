package homework.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создание списка сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 3000, 35));
        employees.add(new Manager("Jane Smith", 5000, 40));
        employees.add(new Employee("Mark Johnson", 4000, 45));

        System.out.println("Before salary increase:");
        for (Employee employee : employees
        ) {
            System.out.println(employee);
        }
        // Повышение зарплаты всем сотрудникам, кроме руководителей
        Manager.increaseSalary(employees.toArray(new Employee[0]), 1000);
        System.out.println("\nAfter salary increase:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        // Сортировка списка сотрудников по зарплате
        Collections.sort(employees, new SalaryComparator());
        System.out.println("\nAfter sorting by salary:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
