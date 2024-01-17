package seminar.five.lection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;

public class StreamsTest {

    public static void main(String[] args) {
//        testIntegerCollection();
        List<String> programmers = List.of(
                "James Gosling",
                "Guido van Rossum",
                "John Carmack",
                "Linus Torvalds",
                "Ken Thompson",
                "Joshua Bloch"

        );

        long result = programmers.stream()
                .filter(name -> name.startsWith("J") && name.length() <= 12)
                .count();

        List<Integer> digits = List.of(1, 4, 1, 5, 9, 2, 6, 5, 3, 5); // 3,1415926535

        System.out.println(digits.stream().dropWhile(n -> n > 0).count());
        String str = Stream.of("[a", "b", "c]").collect(Collectors.joining());
        System.out.println(str);

        Scanner scanner = new Scanner(System.in);
//        int max = Stream
//                .iterate(1 ,i -> scanner.hasNextLine(), i -> i + 1)
//                .map(i -> scanner.nextLine())
//                .map(line -> line.split("\\s"))
//                .flatMap(Arrays::stream)
//                .filter(string -> string.length() > 0)
//                .map(Integer::parseInt)
//                .max(Comparator.naturalOrder())
//                .orElse(Integer.MIN_VALUE);


//        Stream.iterate(1, n -> n < 20, n -> n * 2)
//                .forEach(System.out::println);
//
//        for (int i = 1; i < 20; i *= 2) {
//            System.out.println(i);
//        }
/*        List<Integer> numbers = Stream.iterate(1, i -> i + 1)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(numbers.toString());*/

//        "12345".chars().forEach(System.out::println);
        (new Random()).ints(5, 1, 6).forEach(System.out::println);
        int[] numbers = { 21, 14, 15, 30 };

        double avg = IntStream.of(numbers).average().orElse(0.0); // 20.0

        List<List<String>> values = List.of(
                List.of("1", "2", "3"),
                List.of("green", "yellow", "blue", "red"),
                List.of("g10", "g11", "g12", "g13"),
                List.of("group captain", "general", "major", "admiral")
        );


        Map<Boolean, Long> map = values.stream()
                .filter(l -> l.size() > 3)
                .collect(groupingBy(s -> s.get(0).length() < 4, flatMapping(
                        l -> l.stream().filter(v -> v.contains("g")),
                        counting()
                )));

        // green g10 g11 g12 g13  group captain general
        //{false=3, true=4}


    }

    public static boolean isIsogram(String word) {
        return word.length() == word.chars().distinct().count();
    }

    private static double calcAverageSalary(Collection<Integer> salaries) {
        return salaries.stream()
                .mapToDouble(Double::valueOf)
                .average()
                .orElse(0.0);// write your code here
    }



    /**
     * Отфильтровать и оставить только четные числа.
     * Преобразовать каждое число в его квадрат.
     * Пропустить первые два элемента потока.
     * Ограничить количество элементов в потоке до 4.
     * Отсортировать оставшиеся элементы в порядке убывания.
     * Преобразовать каждое число в строку с префиксом "Number: ".
     */

    //конвеерные и терминальные
    public static void testIntegerCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18);
        List<String> result = numbers.stream()
                .filter(n -> n % 2 ==0)
                .skip(2)
                .limit(4)
                .map(n -> n * n)
                .sorted((a, b) -> a - b)
                .map(n -> "Number: " + n)
                .toList();
        System.out.println(result);
    }

    /**
     * Отфильтровать и оставить только те строки, которые начинаются на букву "J".
     * Избавиться от повторений.
     * Преобразовать все строки к верхнему регистру.
     * Пропустить первую строку.
     * Ограничить количество строк в потоке до 2.
     * Отсортировать строки в алфавитном порядке.
     * Добавить к каждой строке "!".
     */
    public static void testStringsCollection() {
        List<String> strings = Arrays.asList("Java", "Java", "Python", "JavaScript", "C++", "Java", "JavaFX");
        List<String> result = strings.stream()
                .filter(s -> s.startsWith("J"))
                .distinct()
                .map(String::toUpperCase) // используем, когда принимаем какой - то аргумент и сразу же закидываем
                                          // его в другой метод
                                        // второй случай - работаем с каждым элементом и сразу же у этого элемента
                                        // применяем какой-либо метод
                .skip(1)
                .limit(2)
                .sorted()
                .map(s -> s + "!")
                .toList();

        System.out.println(result);
    }

    static class InflationProblem {

  /*      public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {

            return groceries.stream()
                    .collect(Collectors.groupingBy(Grocery::getCategory))
                    .values()
                    .stream()
                    .mapToLong(categoryGroceries -> categoryGroceries.stream()
                            .mapToLong(grocery -> getpriceInNYears(numberOfYears,grocery))
                            .reduce(1l,(total, current) -> total * current))
                    .sum();
        }

        private static long getpriceInNYears(int numberOfYears, Grocery grocery){

            switch (grocery.getCategory()){
                case FRUITS:
                    return (long) Math.pow(4, numberOfYears) * grocery.getCost();
                case DAIRY:
                    return (long) Math.pow(2, numberOfYears) * grocery.getCost();
                case VEGETABLES:
                    return (long) Math.pow(3, numberOfYears) * grocery.getCost();
                default:
                    return grocery.getCost();

            }

        }*/

        public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries){

             return groceries.stream()
                    .map(g -> g.getCost() * Math.pow(g.getCategory().getTimes(),numberOfYears))
                     .mapToLong(Double::longValue)
                     .reduce(0L, Long::sum);

        }


    }

    enum Category {
        VEGETABLES(3),
        FRUITS(4),
        DAIRY(2);
        private long times;

        private Category(long times){
            this.times = times;
        }

        public long getTimes(){
            return this.times;
        }
    }

    static class Grocery {
        private final long cost;
        private final Category category;

        // Imagine that this class has some other fields but they are skipped for simplicity

        public Grocery(long cost, Category category) {
            this.cost = cost;
            this.category = category;
        }

        public long getCost() {
            return cost;
        }

        public Category getCategory() {
            return category;
        }
    }
}
