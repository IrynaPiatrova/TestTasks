package udemy.java.blackbelt.collections.listiterator;

import java.util.*;

public class ListIteratorEX {
    /**
     * https://en.wikipedia.org/wiki/Palindrome
     *
     * @param args
     */
    public static void main(String[] args) {
        String word = "Madam";
        boolean isPalindrome = isPalindrome(word);
        System.out.println("Is the word '" + word + "' palindrome? - " + isPalindrome);
    }

    private static boolean isPalindrome(String word) { //word = "MADAM"
        List<Character> list = getListCharacters(word); //list = [M, A, D, A, M]

        ListIterator<Character> iteratorLeft = list.listIterator();
        ListIterator<Character> iteratorRight = list.listIterator(list.size());
        int times = (int) Math.ceil(list.size() / 2.0);
        while (iteratorLeft.hasNext() && iteratorRight.hasPrevious() && times != 0) {
            if (iteratorLeft.next() != iteratorRight.previous()) {
                return false;
            }
            times--;
        }

        return true;
    }

    private static List<Character> getListCharacters(String word) {
        List<Character> list = new LinkedList<>();
        for (char ch : word.toLowerCase(Locale.ROOT).toCharArray()) {
            list.add(ch);
        }
        return list;
    }
}
