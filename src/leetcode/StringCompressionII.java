package leetcode;

import java.util.*;

public class StringCompressionII {

    public static void main(String[] args) {
        String s = "aabbaa";
        int k = 2;
        int lengthOfOptimalCompression = getLengthOfOptimalCompression(s, k);
        System.out.println("result: " + lengthOfOptimalCompression);
    }

    public static int getLengthOfOptimalCompression(String s, int k) {
        String encodeString = encode(s);
        System.out.println("encodeString = " + encodeString);
        if (k == 0) {
            return encodeString.length();
        }

        String[] split = encodeString.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        System.out.println("split = " + Arrays.toString(split));

        Set<String> setElements = getSetElements(split);

        return getResult(k, encodeString, split, setElements);
    }

    private static int getResult(int k, String encodeString, String[] split, Set<String> setElements) {
        for (String str : setElements) {
            int startIndex = -1;
            int lastIndex = -1;
            int subSum = 0;
            for (int i = 0; i < split.length; i += 2) {
                String value = split[i];
                if (startIndex != -1 && lastIndex == -1) {

                }
                if (startIndex == -1 && str.equals(value)) {
                    startIndex = i;
                } else if (lastIndex == -1 && str.equals(value)) {

                    lastIndex = i;
                    String substring = encodeString.substring(startIndex, lastIndex + 2);
                    System.out.println("substring = " + substring);

                    System.out.println("subSum = " + subSum);
                    if (k >= subSum) {
                        encodeString = (startIndex - 1) > 0 ? getString(split, 0, startIndex - 1) : "" + split[startIndex] + (Integer.parseInt(split[startIndex + 1]) + Integer.parseInt(split[lastIndex + 1])) +
                                getString(split, lastIndex + 2, split.length);
                        System.out.println("encodeString = " + encodeString);
                        k -= subSum;
                        return encodeString.length();
                    }
                } else {
                    subSum += Integer.parseInt(split[i + 1]);
                }
            }
        }
        return 0;
    }


    private static String getString(String[] split, int startIndex, int lastIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < lastIndex; i += 2) {
            String s = split[i];
            if (!s.equals("1")) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    private static Set<String> getSetElements(String[] split) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i += 2) {
            String kye = split[i];
            set.add(kye);
        }
        System.out.println("set = " + set);
        return set;
    }

    private static String encode(String s) {
        char[] chars = s.toCharArray();
        int counter = 0;
        char subValue = chars[0];
        StringBuilder sb = new StringBuilder();

        for (char value : chars) {
            if (subValue == value) {
                counter++;
            } else {
                sb.append(subValue);
                sb.append(counter);
                counter = 1;
                subValue = value;
            }
        }
        sb.append(subValue);
        sb.append(counter);
        System.out.println("sb = " + sb);
        return sb.toString();
    }
}
