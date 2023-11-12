package seminar.two.seminarTask;

import java.util.Arrays;

public class TaskThree {

/*Написать функцию добавления элемента в конец массива таким образом, чтобы
она расширяла массив при необходимости.
∗1 Функция должна возвращать ссылку на вновь созданный внутри себя массив, а
не использовать глобальный
 * */

    public static void main(String[] args) {
        int[] array = {1,3,4,5,6};
        int[] temp = addElemToExpire(array,0);
        System.out.println(Arrays.toString(temp));
    }
    public static int[] addElemToExpire(int[] array, int value){

        int[] temp = new int[array.length + 1];
        temp[array.length] = value;
        System.arraycopy(array,0,temp,0,array.length);
        return temp;
    }

}
