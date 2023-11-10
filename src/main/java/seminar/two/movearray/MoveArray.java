package seminar.two.movearray;

import java.util.Arrays;
import java.util.Random;


/* Написать метод, принимающий на вход массив чисел и параметр n. Метод должен
осуществить циклический (последний элемент при сдвиге становится первым)
сдвиг всех элементов массива на n позиций
* */
public class MoveArray {

    public static void main(String[] args) {
        int[] arrayToShift = createArray();
        printArray(arrayToShift);
        int[] shiftedArray = shiftArray3(arrayToShift,5);
        System.out.println();
        printArray(shiftedArray);
    }

    public static int[] shiftArray(int[] arr, int shiftValue){

        int[] newArray = new int[arr.length];
        shiftValue -= arr.length;
        if(shiftValue < 0) shiftValue *= -1;
        for(int i = 0; i < arr.length; i++){
            int newIndex = (i + shiftValue) % arr.length;
            newArray[i] = arr[newIndex];
        }
        return newArray;

    }

    public static int[] createArray(){
        Random random = new Random();
        int[] newArray = random.ints(0, 100).distinct().limit(6).toArray();
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.println(i);
        }
    }

    public static int[] shiftArray2(int[] arr, int shiftValue){
        if((arr == null) || (arr.length == 0) || (shiftValue <= 0)) throw new IllegalStateException("");
        while(shiftValue > 0){
            int lastInt = arr[arr.length - 1];
            for(int i = 0; i < arr.length; i++){

                int currentInt = arr[i];
                arr[i] = lastInt;
                lastInt = currentInt;
            }
            shiftValue--;
        }
        return arr;
    }

    /* Если рассмотреть наборы изменяемых элементов, то мы увидим, что количество таких наборов, внутри которых мы
     будем итеративно менять местами элементы, будет равно наименьшему общему делителю для размера массива и размера сдвига.
    * */
    public static int[] shiftArray3(int[] arr, int shiftValue){

        int currentIndex, moveIndex, buffer;
        for(int i = 0; i < greatestCommonDivisor(shiftValue, arr.length); i++){
            buffer = arr[i];
            currentIndex = i;

            if(shiftValue > 0){
                while (true){
                    moveIndex = currentIndex + shiftValue;
                    if(moveIndex >= arr.length){
                        moveIndex -= arr.length;
                    }
                    if(moveIndex == i){
                        break;
                    }
                    arr[currentIndex] = arr[moveIndex];
                    currentIndex = moveIndex;
                }
            }else if(shiftValue < 0){
                while (true){
                    moveIndex = currentIndex + shiftValue;
                    if(moveIndex < 0){

                        moveIndex += arr.length;
                    }
                    if(moveIndex == i){
                        break;
                    }
                    arr[currentIndex] = arr[moveIndex];
                    currentIndex = moveIndex;
                }
            }
            arr[currentIndex] = buffer;
        }
        return arr;

    }

    private static int greatestCommonDivisor(int a, int b){
        if(b == 0){
            return a;
        }else{
            return greatestCommonDivisor(b, a % b);
        }
    }

}
