package seminar.five.stepik;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class SolutionTwo {

    class PhoneBook {
        private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

        public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
            nameToPhoneNumbersMap.merge(name, numbers, (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()));
        }

        public void printPhoneBook() {
            nameToPhoneNumbersMap.forEach((key, value) -> {
                System.out.println(key);
                value.forEach(System.out::println);
            });
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

        @Override
        public String toString() {
            return this.type.name() + ": " + number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PhoneNumber that = (PhoneNumber) o;

            if (type != that.type) return false;
            return Objects.equals(number, that.number);
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + (number != null ? number.hashCode() : 0);
            return result;
        }
    }
}
