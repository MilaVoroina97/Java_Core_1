package homework.three.SOLID;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<IncreaseSalary> employees = new ArrayList<>();
        employees.add(new IncreaseEmployeeSalary("John Doe", 3000.0, 35));
        employees.add(new IncreaseManagerSalary("Jane Smith", 5000.0, 40));
        employees.add(new IncreaseEmployeeSalary("Mark Johnson", 4000.0, 45));
        for(IncreaseSalary employee : employees){
            employee.increaseSalary(1000.0);
        }

        System.out.println("\nAfter salary increase:");
        for (IncreaseSalary employee : employees) {
            System.out.println(employee);
        }

        Collections.sort(employees, new SalaryComparator());
        System.out.println("\nAfter sorting by salary:");
        for (IncreaseSalary employee : employees) {
            System.out.println(employee);
        }

        List<IncreaseSalaryService> increaseSalaryServices = new ArrayList<>();
        increaseSalaryServices.add(new IncreaseSalaryService(new IncreaseEmployeeSalary("John Doe", 3000.0, 35)));
        increaseSalaryServices.add(new IncreaseSalaryService(new IncreaseManagerSalary("Jane Smith", 5000.0, 40)));
        increaseSalaryServices.add(new IncreaseSalaryService(new IncreaseManagerSalary("Mark Johnson", 4000.0, 45)));
        for(IncreaseSalaryService increaseSalaryService : increaseSalaryServices){
            increaseSalaryService.increaseSalary(800);
        }

        System.out.println("\nAfter salary increase:");
        for (IncreaseSalaryService increaseSalaryService : increaseSalaryServices) {
            System.out.println(increaseSalaryService);
        }

    }
}
