package seminar.four.taskThree;

public class SumOfNumbersInSquareArray {

    public static void main(String[] args) {

        int[][] array = new int[4][5];
        sumOfNumbers(array);
    }

    public static int sumOfNumbers(int array[][]){
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
