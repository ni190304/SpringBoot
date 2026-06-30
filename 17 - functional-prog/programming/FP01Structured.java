import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(12, 9, 23, 32, 11));
        printEvenNumbersInListStructured(List.of(12, 9, 23, 32, 11));

    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {

        for (int integer : numbers) {
            System.out.println(integer);
        }

    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {

        for (int integer : numbers) {
            if (integer % 2 == 0) {
                System.out.println(integer);
            }
        }

    }
}
