package parseTheStringTask;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParseTheStringTaskService {

    public static String getStringWithoutParenthesisOnTheSides(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static List<String> getSortedValues(String str) {
        return Arrays.stream(str.split(ParseTheStringTaskConstants.COMMA))
                .map(removeSpaces())
                .sorted()
                .collect(Collectors.toList());
    }

    public static Function<String, String> removeSpaces() {
        return s -> s.replaceAll("\\s", ParseTheStringTaskConstants.EMPTY_STR);
    }

    public static String getNewPref(String pref) {
        return new StringBuilder(pref).append(ParseTheStringTaskConstants.DASH_STR).toString();
    }

    public static String getLastValue(String str) {
        String[] split = str.split(ParseTheStringTaskConstants.COMMA);
        return split[split.length - 1];
    }

    public static String getResultString(String stringWithoutParenthesis, String pref) {
        return new StringBuilder(pref)
                .append(ParseTheStringTaskConstants.STR_SPACE)
                .append(stringWithoutParenthesis)
                .append(System.getProperty("line.separator")).toString();
    }

    public static int getClosingParenthesisPosition(String str, int indexFirstParenthesis) {
        char[] chars = str.toCharArray();
        int counter = 0;

        if (indexFirstParenthesis < 0) {
            return -1;
        }

        for (int i = indexFirstParenthesis; i <= chars.length - 1; i++) {
            if (chars[i] == '(') {
                counter++;
            }

            if (chars[i] == ')') {
                counter--;
            }

            if (counter == 0) {
                return i;
            }
        }
        return -1;
    }
}
