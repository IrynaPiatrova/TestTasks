package parseTheStringTask;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParseTheStringTask_v2 {

    public static void main(String[] args) {
        System.out.println("Result : ");
        String stringWithoutParenthesisOnTheSides =
                ParseTheStringTaskConstants.STR.substring(1, ParseTheStringTaskConstants.STR.length() - 1);
        System.out.println(
                getParseResultStringValue(stringWithoutParenthesisOnTheSides, ParseTheStringTaskConstants.EMPTY_STR));
    }

    private static String getParseResultStringValue(String stringWithoutParenthesisOnTheSides, String pref) {
        StringBuilder str = new StringBuilder();

        int indexFirstParenthesis =
                stringWithoutParenthesisOnTheSides.indexOf(ParseTheStringTaskConstants.OPEN_PARENTHESIS);
        int indexClosingParenthesis =
                getClosingParenthesisPosition(stringWithoutParenthesisOnTheSides, indexFirstParenthesis);

        if (indexFirstParenthesis < 0 || indexClosingParenthesis < 0) {
            return getResultString(removeSpaces().apply(stringWithoutParenthesisOnTheSides), pref);
        }

        //append values before first parenthesis
        str.append(stringWithoutParenthesisOnTheSides, 0, indexFirstParenthesis);

        //get last value before first parenthesis
        String keyParentValue = getLastValue(str);

        //append values after last parenthesis
        str.append(stringWithoutParenthesisOnTheSides, indexClosingParenthesis + 1,
                stringWithoutParenthesisOnTheSides.length());

        StringBuilder result = new StringBuilder();

        getSortedValues(str).forEach(strValue -> {
            result.append(getResultString(strValue, pref));
            if (keyParentValue != null && keyParentValue.equals(strValue)) {
                String hierarchicalSubstring =
                        stringWithoutParenthesisOnTheSides.substring(indexFirstParenthesis + 1, indexClosingParenthesis);
                result.append(getParseResultStringValue(hierarchicalSubstring, getNewPref(pref)));
            }
        });

        return result.toString();
    }

    private static List<String> getSortedValues(StringBuilder str) {
        return Arrays.stream(str.toString().split(ParseTheStringTaskConstants.COMMA)).map(removeSpaces()).sorted()
                .collect(Collectors.toList());
    }

    private static Function<String, String> removeSpaces() {
        return s -> s.replaceAll("\\s", ParseTheStringTaskConstants.EMPTY_STR);
    }

    private static String getNewPref(String pref) {
        return new StringBuilder(pref).append(ParseTheStringTaskConstants.DASH_STR).toString();
    }

    private static String getLastValue(StringBuilder str) {
        String[] split = str.toString().split(ParseTheStringTaskConstants.COMMA);
        return split[split.length - 1];
    }

    private static String getResultString(String stringWithoutParenthesis, String pref) {
        return new StringBuilder(pref).append(ParseTheStringTaskConstants.STR_SPACE).append(stringWithoutParenthesis)
                .append(System.getProperty("line.separator")).toString();
    }

    private static int getClosingParenthesisPosition(String str, int indexFirstParenthesis) {
        char[] chars = str.toCharArray();
        int counter = 0;

        if (indexFirstParenthesis < 0) {
            return -1;
        }

        for (int i = indexFirstParenthesis; i <= chars.length; i++) {
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
