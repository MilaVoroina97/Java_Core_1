package homework.three;

public class Manager extends Employee{


    public Manager(String name, double salary, int age) {
        super(name, salary, age);
    }
    /**
     * Статический метод для повышения зарплаты сотрудников, кроме руководителей.
     *
     * @param employees Массив сотрудников
     * @param amount    Сумма повышения
     */
    public static void increaseSalary(Employee[] employees, double amount) {
        for (Employee employee : employees
        ) {
            if (!(employee instanceof Manager)) {
                employee.increaseSalary(amount);
            }
        }
    }
}
