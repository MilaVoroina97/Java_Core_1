package homework.five;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(

                new Student("Иван", Arrays.asList(4.5, 5.0, 4.0), "Информатика"),

                new Student("Петр", Arrays.asList(4.0, 4.5, 5.0), "Математика"),

                new Student("Анна", Arrays.asList(5.0, 5.0, 5.0), "Информатика"),

                new Student("Мария", Arrays.asList(4.0, 4.5, 4.5), "Информатика"),

                new Student("Алексей", Arrays.asList(4.5, 4.5, 4.5), "Литература")

        );



        // Фильтрация студентов специальности "Информатика" с средним баллом выше 4.5

        List<Student> filteredStudents = students.stream()

                .filter(student -> student.getSpecialty().equals("Информатика"))

                .filter(student -> student.getAverageGrade() > 4.5)

                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())

                .limit(5)

                .collect(Collectors.toList());



        // Вывод результатов

        filteredStudents.stream()

                .forEach(student -> System.out.println(student.getName() + ": " + student.getAverageGrade()));

    }
}

