

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(12, 9, 23, 32, 11, 20));
        printEvenNumbersInListStructured(List.of(12, 9, 23, 32, 11, 20));
        printSquaresOfNumbersInListStructured(List.of(12, 9, 23, 32, 11, 20));

        List<String> courses = List.of(
                "Spring", "Springboot", "Sanket", "springhh", "nih");

        courses.stream()
                .filter(course -> course.toLowerCase().contains("spring"))
                .forEach(System.out::println);

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {

        numbers.stream()
                .forEach(System.out::println);

    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> number % 2 == 0) // lambda
                .forEach(System.out::println);

    }

    private static void printSquaresOfNumbersInListStructured(List<Integer> numbers) {

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number) // lambda
                .forEach(System.out::println);

    }
}
