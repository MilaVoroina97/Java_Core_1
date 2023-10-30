package homework.two;

public class HasZeroNeighbors {

    /**
     * Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с
     * нулевым значением.
     *
     * @param numbers Принимает массив
     * @return Возвращает true или false
     */
    public static boolean hasZeroNeighbors(int[] numbers) {
        if (numbers.length < 2) {
            return false;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0 && numbers[i + 1] == 0) {

                return true;
            }
        }

        return false;
    }
}
