package seminar.two.seminarTask;

import java.util.Arrays;

public class TaskOne {

    /* Создать квадратный целочисленный массив, заполнить его по диагоналям единицами
    * */

    public static void main(String[] args) {
        printArray(makeDiagonalArray(5));
    }
    public static int[][] makeDiagonalArray(int size){

        int[][] diagonalArray = new int[size][size];
        for(int i = 0, j = diagonalArray.length - 1; i < size; i++, j--){

            diagonalArray[i][i] = 1;
            diagonalArray[i][j] = 1;
        }
        return diagonalArray;
    }

    public static void printArray(int[][] array){
//        for(int i = 0; i < array.length; i++){
//            for (int j = 0; j < array.length; j++){
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }

        for(int[] row : array){
            System.out.println(Arrays.toString(row));
        }
    }
}
