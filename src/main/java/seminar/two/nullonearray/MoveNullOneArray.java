package seminar.two.nullonearray;

import java.util.Arrays;
import java.util.Random;

public class MoveNullOneArray {

    public static void main(String[] args) {
        int[] array = {1,0,0,1,1};
        array = changeOneToNullInArray2(array);
        printArray(array);

    }

    public static int[] changeOneToNullInArray(int [] arr){

        for(int i = 0; i < arr.length; i++){

            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        return arr;
    }

    public static int[] changeOneToNullInArray2(int[] arr){
        for(int i = 0; i < arr.length; i++){

            arr[i] = 1 - arr[i];
            //arr[i] = (arr[i] - 1) * -1;
            //arr[i] = (arr[i] + 1) % 2;
        }
        return arr;
    }



    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }


}
