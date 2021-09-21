package leetcode.gcds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SolutionGCD {

    /*
    https://leetcode.com/problems/number-of-different-subsequences-gcds/

    int[] nums = {5,15,40,5,6}; // Output: 7

    - 5         | 5
    - 5,15      | 5
    - 5,15,40   | 5
    - 5,15,40,6 | 1
    - 5,40      | 5
    - 5,40,6    | 1
    - 5,6       | 1
    - 15        | 15
    - 15,40     | 5
    - 15,40,6   | 1
    - 15,6      | 3
    - 40        | 40
    - 40,6      | 2
    - 6         | 6

    GCDs = {1, 2, 3, 5, 6, 15,40}
     */
    public static Set<Integer> setGCDs = new HashSet<>();

    public static void main(String[] args) {
        // int[] nums = {6, 10, 3}; // Output: 5
        int[] nums = {5, 15, 40, 5, 6}; // Output: 7

        int countDifferentSubsequenceGCDs = countDifferentSubsequenceGCDs(nums);
        System.out.println("Result = " + countDifferentSubsequenceGCDs);
    }


    public static int countDifferentSubsequenceGCDs(int[] nums) {
        Set<Integer> setIntegers = getSetIntegers(nums);
        setGCDs.addAll(setIntegers);
        Set<Integer> setIntegersCopy = new HashSet<>(Set.copyOf(setIntegers));

        setIntegers.forEach(mainNum -> {
            if (setIntegers.size() != 0) {
                setIntegersCopy.remove(mainNum);
                addGCDs(setIntegersCopy, mainNum);
            }
        });

        return setGCDs.size();
    }

    private static void addGCDs(Set<Integer> setIntegers, Integer mainNum) {
        setIntegers.forEach(nextNum -> {
            int gcd = gcd(mainNum, nextNum);
            setGCDs.add(gcd);

            if (setIntegers.size() != 0) {
                Set<Integer> setIntegersCopy = new HashSet<>(Set.copyOf(setIntegers));
                setIntegersCopy.remove(nextNum);
                addGCDs(setIntegersCopy, gcd);
            }
        });
    }

    private static Set<Integer> getSetIntegers(int[] nums) {
        return Arrays.stream(nums)
                .boxed() // return Stream<Integer>
                .collect(toSet());
    }

    static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
