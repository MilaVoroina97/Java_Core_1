package seminar.two.seminarTask;

public class TaskTwo {

    /*Написать метод, в который передается не пустой одномерный
целочисленный массив, метод должен вернуть true если в массиве есть
место, в котором сумма левой и правой части массива равны. Примеры:
checkBalance([1, 1, 1, || 2, 1]) → true,
checkBalance([2, 1, 1, 2, 1]) → false,
checkBalance([10, || 1, 2, 3, 4]) → true.
Абстрактная граница показана символами ||, эти символы в массив не
входят.
* */

    /* Решение : в каждый момент прохода массива необходимо сравнивать правую и левую сторону:

    1. Посчитать сразу всю сумму массива и сохранить ее в правую часть
    2. Далее постепенно вычитать левую сторону массива и после каждого вычитания сравнивать обе стороны
    * */

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 1};
        System.out.println(checkBalance1(array));
    }
    public static boolean checkBalance1(int[] array){

        int sum = 0;
        for(int i : array){
            sum += i;
        }
        int left = 0;
        for(int i = 0; i < array.length; i++){

            left += array[i];
            sum -= array[i];
            if(sum == left) return true;
        }

        return false;

    }

    public static boolean checkBalance2(int[] array){
        int lbound = 0;
        int rbound = array.length - 1;
        int left = 0;
        int right = 0;
        while (lbound <= rbound){
            if(left > right){

                right += array[rbound--];

            }else {
                left += array[lbound++];
            }
        }
        return left == right;
    }

}
