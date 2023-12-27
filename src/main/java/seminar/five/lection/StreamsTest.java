package seminar.five.lection;

import java.util.Arrays;
import java.util.List;

public class StreamsTest {

    public static void main(String[] args) {
        testIntegerCollection();
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
}
