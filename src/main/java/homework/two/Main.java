package homework.two;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 2, 3, 4, 8, 9, 3, 0};
        int[] nums2 = {2, 2, 0, 0, 2, 3, 8, 0, 0, 0};
        int[] nums3 = {1, 3, 5, 3, 33, 0, 333, 0};

        printResult(nums1, "Количество чётных элементов", CountEvens.countEvens(nums1));
        printResult(nums2, "Количество чётных элементов", CountEvens.countEvens(nums2));
        printResult(nums3, "Количество чётных элементов", CountEvens.countEvens(nums3));

        System.out.println();

        printResult(nums1, "Разница между мин. и макс.", FindDifference.findDifference(nums1));
        printResult(nums2, "Разница между мин. и макс.", FindDifference.findDifference(nums2));
        printResult(nums3, "Разница между мин. и макс.", FindDifference.findDifference(nums3));

        System.out.println();

        printResult(nums1, "Имеются ли два соседних элемента, с нулевым значением",
                HasZeroNeighbors.hasZeroNeighbors(nums1));
        printResult(nums2, "Имеются ли два соседних элемента, с нулевым значением",
                HasZeroNeighbors.hasZeroNeighbors(nums2));
        printResult(nums3, "Имеются ли два соседних элемента, с нулевым значением",
                HasZeroNeighbors.hasZeroNeighbors(nums3));

    }

    /**
     * Метод для печати результатов
     *
     * @param nums   Массив
     * @param label  Наименование метода
     * @param result Результат метода
     */
    public static void printResult(int[] nums, String label, Object result) {
        System.out.print(Arrays.toString(nums) + " ");
        System.out.println(label + ": " + result);
    }
}
