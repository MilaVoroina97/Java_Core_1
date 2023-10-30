package homework.two;

public class CountEvens {

    /**
     * Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) →
     * 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
     * @param numbers Принимает массив
     * @return возвращает количество чётных элементов массива.
     */
    public static int countEvens(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
