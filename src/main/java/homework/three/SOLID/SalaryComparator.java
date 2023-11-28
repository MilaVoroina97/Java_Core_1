package homework.three.SOLID;

import java.util.Comparator;

public class SalaryComparator implements Comparator<IncreaseSalary> {
    @Override
    public int compare(IncreaseSalary emp1, IncreaseSalary emp2) {
        double salary1 = emp1.getSalary();
        double salary2 = emp2.getSalary();
        return Double.compare(salary1, salary2);
    }
}
