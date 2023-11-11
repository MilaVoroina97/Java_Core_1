package homework.five;

import java.util.List;

public class Student {

    private String name;

    private List<Double> grades;

    private String specialty;



    public Student(String name, List<Double> grades, String specialty) {

        this.name = name;

        this.grades = grades;

        this.specialty = specialty;

    }



    public double getAverageGrade() {

        double sum = grades.stream().mapToDouble(Double::doubleValue).sum();

        return sum / grades.size();

    }



    public String getName() {

        return name;

    }



    public String getSpecialty() {

        return specialty;

    }
}
