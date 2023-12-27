package seminar.five.lection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };

//        PlainInterface plainInterface = Integer::sum;
//        PlainInterface plainInterface1 = Integer::compare;

//        List<String> myList = Arrays.asList("Привет","мир","!","Я","родился","!");
//
//        myList.stream().filter(str -> str.length() > 4)
//                .filter(str -> str.contains("о"))
//                .forEach(System.out::println);
//
//        Stream.of(4,2,7,10,32,90,90,2,32,32).sorted()
//                .distinct()
//                .map(number -> "number : " + number + " and its square: " + number * number)
//                .forEach(System.out::println);

        List<User> list = Arrays.asList(new User("Mike",50), new User("Rice",40),
                new User("Fate",30));

        list.stream().map(user -> new User(user.name,user.age - 5))
                .filter(user -> user.age <= 35 )
                .forEach(System.out::println);

        List<String> list1 = Arrays.asList("Привет", "Как дела?", "Пропеллер!", "никель");
        list1.stream().map(String::length).forEach(System.out::println);
        System.out.println(list1.stream().filter(s -> s.length()>4).findAny());

    }


}
