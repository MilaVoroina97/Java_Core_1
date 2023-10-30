package homework.two;

public class FindDifference {

    /**
     * Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами
     * переданного не пустого массива.
     *
     * @param nums Принимает массив
     * @return Возвращаем разницу между максимальным и минимальным элементами
     */
    public static int findDifference(int[] nums) {
        if (nums.length <= 1) {
            return 0; // или другое значение по умолчанию
        }

        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        return max - min;
    }
}
