import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "mango");

        Optional<String> optional = fruits.stream()
                                           .filter(fruit -> fruit.startsWith("z"))
                                           .findFirst();

        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> fruit = Optional.of("banana");
        Optional<String> empty = Optional.empty();


    }
}