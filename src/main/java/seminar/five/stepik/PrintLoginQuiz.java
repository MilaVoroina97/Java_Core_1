package seminar.five.stepik;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class PrintLoginQuiz {
    public static void printLoginIfPro(Set<User> users, String id) {

        User user = findUserById(users,id);
        Optional.of(user)
                .filter(proUser -> proUser.getAccount().isPresent() &&
                        proUser.getAccount().get().getType().equals("pro"))
                .map(User::getLogin)
                .ifPresent(System.out::println);
    }

    public static void printLoginIfProSecond(Set<User> users, String id){

        users.stream()
                .filter(user -> user.getAccount()
                        .map(Account::getId)
                        .filter(id::equals)
                        .isPresent())
                .filter(user -> user.getAccount()
                        .map(Account::getType)
                        .filter("pro"::equals)
                        .isPresent())
                .map(User::getLogin)
                .findAny()
                .ifPresent(System.out::println);
    }

    public static void printLoginIfProThird(Set<User> users, String id){
        users.forEach(user -> user.getAccount()
                .filter(acc -> "pro".equals(acc.getType()) && id.equals(acc.getId()))
                .ifPresent(acc -> System.out.println(user.getLogin())));
    }

    public static void printLoginIfProFourth(Set<User> users, String id){
        users.forEach(user -> Optional
                        .ofNullable(user)
                        .flatMap(User::getAccount)
                        .filter(account -> account.getType().equals("pro") && account.getId().equals(id))
                        .map(account -> user.getLogin())
                        .ifPresent(System.out::println));
    }
    private static User findUserById(Set<User> users, String id){

        User result = null;
        for(User user : users){
            String targetId  = user.getAccount()
                    .orElseThrow(() -> new RuntimeException("User not found"))
                    .getId();

            if(id.equals(targetId)){

                result = user;
            }
        }

        return result;

    }


    public static Stream<String> mergeEmployees(Stream<String> empls1, Stream<String> empls2) {

        return Stream.concat(empls1,empls2)
                .sorted();

    }

//            return users.stream()
//                    .filter(user -> user.getAccount()
//            .map(Account::getId)
//                     .map(id::equals)
//                     .orElse(false))
//            .findAny();
//    Another variant:
//
//            return users.stream()
//            .filter(user -> user.getAccount()
//            .map(Account::getId)
//                     .filter(id::equals)
//                     .isPresent())
//            .findAny();
}
