package udemy.java.tests;

/**
 * It is necessary to implement a program that performs a linear search in the array
 * (i.e., sequentially iterate through the elements of the array until the desired element is found).
 * <p>
 * The linear search function should return the index of the desired element in the array.
 * If the array does not contain the desired element, the function should return -1
 */

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Index for 11 = " + findIndex(array, 11));
        System.out.println("Index for 3 = " + findIndex(array, 3));
    }

    private static int findIndex(int[] array, int element) {
        for (int index = 0; index < array.length; index++) {
            if (element == array[index]) {
                return index;
            }
        }

        return -1;
    }
}
