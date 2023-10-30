package homework.two;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arrayOne = {2, 1, 2, 3, 4, 8, 9, 3, 0};
        int[] arrayTwo = {2, 2, 0, 0, 2, 3, 8, 0, 0, 0};
        int[] arrayThree = {1, 3, 5, 3, 33, 0, 333, 0};

        printResult(arrayOne, "Количество чётных элементов", CountEvens.countEvens(arrayOne));
        printResult(arrayTwo, "Количество чётных элементов", CountEvens.countEvens(arrayTwo));
        printResult(arrayThree, "Количество чётных элементов", CountEvens.countEvens(arrayThree));

        System.out.println();

        printResult(arrayOne, "Разница между мин. и макс.", FindDifference.findDifference(arrayOne));
        printResult(arrayTwo, "Разница между мин. и макс.", FindDifference.findDifference(arrayTwo));
        printResult(arrayThree, "Разница между мин. и макс.", FindDifference.findDifference(arrayThree));

        System.out.println();

        printResult(arrayOne, "Имеются ли два соседних элемента, с нулевым значением",
                HasZeroNeighbors.hasZeroNeighbors(arrayOne));
        printResult(arrayTwo, "Имеются ли два соседних элемента, с нулевым значением",
                HasZeroNeighbors.hasZeroNeighbors(arrayTwo));
        printResult(arrayThree, "Имеются ли два соседних элемента, с нулевым значением",
                HasZeroNeighbors.hasZeroNeighbors(arrayThree));

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
