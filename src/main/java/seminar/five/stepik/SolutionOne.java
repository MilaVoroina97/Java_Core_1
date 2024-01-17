package seminar.five.stepik;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SolutionOne {

    class PhoneBook {
        private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

        public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
            // write your code here
            Collection<PhoneNumber> modifyList = new ArrayList<>(numbers);
            BiFunction<Collection<PhoneNumber>,Collection<PhoneNumber>, Collection<PhoneNumber>> phoneNumberBiFunction =
                    (x, y) ->
            {
                x.addAll(y);
                return x;
            };
            nameToPhoneNumbersMap.merge(name, modifyList, phoneNumberBiFunction);

        }

        public void printPhoneBook() {
            // write your code here
            nameToPhoneNumbersMap.forEach((k, v) -> {
                System.out.printf("%s\n", k);
                v.forEach(phoneNumber ->
                        System.out.printf("%s: %s%n", phoneNumber.getType(), phoneNumber.getNumber()));
            } );
        }
    }

    enum PhoneNumberType {
        MOBILE, HOME, WORK,
    }

    class PhoneNumber {

        private PhoneNumberType type;
        private String number;

        public PhoneNumber(PhoneNumberType type, String number) {
            this.type = type;
            this.number = number;
        }

        public PhoneNumberType getType() {
            return type;
        }

        public String getNumber() {
            return number;
        }
    }


}
