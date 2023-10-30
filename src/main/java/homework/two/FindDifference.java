package homework.two;

public class FindDifference {

    /**
     * Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами
     * переданного не пустого массива.
     *
     * @param numbers Принимает массив
     * @return Возвращаем разницу между максимальным и минимальным элементами
     */
    public static int findDifference(int[] numbers) {
        if (numbers.length <= 1) {
            return 0; // или другое значение по умолчанию
        }

        int max = numbers[0];
        int min = numbers[0];

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        return max - min;
    }
}
