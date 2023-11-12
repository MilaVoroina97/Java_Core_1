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
        shiftArray4(arrayToShift,3);
        System.out.println();
        printArray(arrayToShift);
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
        int[] newArray = random.ints(0, 100).distinct().limit(7).toArray();
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static void printArray(int[] array){

        System.out.println(Arrays.toString(array));
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

    public static void shiftArray4(int[] array, int shiftValue){

        shiftValue %= array.length;
        int shift = array.length + shiftValue;
        shift %= array.length;

        for(int i = 0; i < shift; i++){

            int temp = array[array.length - 1];
            System.arraycopy(array,0,array,1,array.length - 1);
            array[0] = temp;
        }
    }

}
