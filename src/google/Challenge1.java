package google;

import java.util.ArrayList;

public class Challenge1 {
    public static void main(String args[]) {
        String str = "abccbaabccba";
        Integer numberOfCharacters = str.length();
        ArrayList<Integer> factorsOfNumber = findFactorsOfNumber(numberOfCharacters);

        char[] charArray = str.toCharArray();

        int result = getValidFactor(str, numberOfCharacters, factorsOfNumber, charArray);

    }

    private static int getValidFactor(String str, Integer numberOfCharacters, ArrayList<Integer> factorsOfNumber,
                                      char[] charArray) {
        for (Integer factor : factorsOfNumber) {
            int portionSize = numberOfCharacters / factor;
            String portion = getPortion(charArray, portionSize);
            String replace = str.replace(portion, "");
            if ("".equals(replace)) {
                return factor;
            }
        }
        return 1;
    }

    private static String getPortion(char[] charArray, int portionSize) {
        StringBuilder portion = new StringBuilder();
        for (int i = 0; i < portionSize; i++) {
            portion.append(charArray[i]);
        }
        return portion.toString();
    }

    private static ArrayList<Integer> findFactorsOfNumber(int number) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = number; i > 0; i--) {
            if (0 == (number % i)) {
                factors.add(i);
            }
        }
        return factors;
    }
}
