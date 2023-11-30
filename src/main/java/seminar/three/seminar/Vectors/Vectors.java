package seminar.three.seminar.Vectors;

import java.util.*;


/**
 * Имеются 2 вектора.
 * Требуется написать функцию, которая считает количество общих чисел между двумя векторами и
 * возвращает результат в виде вектора. В ответе необходимо исключить кратность при дубликации*/
public class Vectors {

    public static List<Integer> countCommonNumbers(List<Integer> list1, List<Integer> list2) {

        List<Integer> resultList = new ArrayList<>();
        int resultCount = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        for(int i = 0; i < list1.size(); i++){
            int n1 = list1.get(i);
            int n2 = list2.get(i);
            if(!set1.contains(n1)){
                set1.add(n1);
                if(set2.contains(n1)) ++resultCount;
            }if(!set2.contains(n2)){
                set2.add(n2);
                if(set1.contains(n2)) ++ resultCount;
            }

            resultList.add(resultCount);
        }


        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(2, 0, 1, 3);

        List<Integer> result = countCommonNumbers(list1, list2);
        System.out.println(result); // Должно вывести [0, 1, 2, 3]

        list1 = Arrays.asList(1, 1, 2, 3);
        list2 = Arrays.asList(2, 1, 3, 1);

        result = countCommonNumbers(list1, list2);
        System.out.println(result); // Должно вывести [0, 1, 2, 3]
    }
}
