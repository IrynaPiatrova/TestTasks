package udemy;

/**
 * You need to implement a program that displays numbers from 1 to 100 on the screen.
 * In this case, instead of numbers that are multiples of three, the program should output the word "Fizz",
 * and instead of numbers that are multiples of five — the word"Buzz".
 * If the number is a multiple of both 3 and 5, then the program should output the word " FizzBuzz»
 */

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            printValue(i);
        }
    }

    private static void printValue(int i) {
        if (i % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (i % 3 == 0) {
            System.out.print("Fizz");
        } else if (i % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.println(i);
        }
    }
}
