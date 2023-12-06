package seminar.four.taskThree;


/**
 *  Для проверки напишите программу, преобразующую квадратный массив целых
 * чисел 5х5 в сумму чисел в этом массиве, при этом, программа должна выбросить
 * исключение, если строк или столбцов в исходном массиве окажется не 5.
 */

public class SumOfNumbersInSquareArray {

    public static void main(String[] args) {

        int[][] array = new int[4][5];
        System.out.println(sumOfNumbers(array));
    }

    public static int sumOfNumbers(int[][] array){
        int sum = 0;
        if(array[0].length == 5 && array.length == 5){
            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array.length; j++){
                    sum += array[i][j];
                }
            }
        }else
            throw new IndexOutOfBoundsException("This array must have 5 columns and 5 rows");
        return sum;
    }
}
