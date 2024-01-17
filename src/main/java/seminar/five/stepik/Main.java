package seminar.five.stepik;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hi!");

        optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));

        System.out.println(optional.or(() -> Optional.of("empty")).orElse("empty"));
        System.out.println(optional.filter(str -> str.length() > 5).orElse("empty"));


    }
}
