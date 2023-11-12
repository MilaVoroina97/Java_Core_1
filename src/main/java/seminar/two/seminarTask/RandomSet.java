package seminar.two.seminarTask;


import java.util.*;

/**Написать структуру данных, хранящую целые числа и поддерживающую следующие операции:
 *     добавление значения в множество
 *     проверка есть ли значение в множестве
 *     удаление значения из множества
 *     получение равномерно случайного значения из множества.
 *     все операции O(1)
 */
public class RandomSet {

    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;

    public RandomSet(){

        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public void add(int value){

        if(!map.containsKey(value)){
            list.add(value);
            map.put(value, list.size() - 1);
        }
    }

    public boolean contains(int value){return map.containsKey(value);}

    public int getRandom(){return list.get(random.nextInt(list.size()));}

    public void remove(int value){
        if(map.containsKey(value)){

            int index = map.get(value);
            int lastElement = list.get(list.size() - 1);
            list.set(index,lastElement);
            map.put(lastElement,index);

            list.remove(list.size() - 1);
            map.remove(value);
        }
    }

}
