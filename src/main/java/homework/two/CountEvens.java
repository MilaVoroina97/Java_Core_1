package homework.two;

public class CountEvens {

    /**
     * Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) →
     * 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
     * @param nums Принимает массив
     * @return возвращает количество чётных элементов массива.
     */
    public static int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
