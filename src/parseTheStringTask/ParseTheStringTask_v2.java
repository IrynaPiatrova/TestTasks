package parseTheStringTask;

import java.util.Arrays;
import java.util.List;
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
                getIndex(stringWithoutParenthesisOnTheSides, ParseTheStringTaskConstants.OPEN_PARENTHESIS);
        int indexLastParenthesis =
                stringWithoutParenthesisOnTheSides.lastIndexOf(ParseTheStringTaskConstants.CLOSE_PARENTHESIS);

        if (indexFirstParenthesis <= 0 || indexLastParenthesis <= 0) {
            return getResultString(stringWithoutParenthesisOnTheSides, pref);
        }

        //append values before first parenthesis
        str.append(stringWithoutParenthesisOnTheSides, 0, indexFirstParenthesis);
        String keyParentValue = getKeyParentValue(str);

        //append values after last parenthesis
        str.append(stringWithoutParenthesisOnTheSides, indexLastParenthesis + 1,
                stringWithoutParenthesisOnTheSides.length());

        List<String> values = Arrays.stream(str.toString().split(ParseTheStringTaskConstants.COMMA))
                .map(s -> s.replaceAll("\\s", ParseTheStringTaskConstants.EMPTY_STR)).sorted()
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        values.forEach(strValue -> {
            result.append(getResultString(strValue, pref));
            if (keyParentValue != null && keyParentValue.equals(strValue)) {
                String hierarchicalSubstring =
                        stringWithoutParenthesisOnTheSides.substring(indexFirstParenthesis + 1, indexLastParenthesis);
                result.append(getParseResultStringValue(hierarchicalSubstring,
                        new StringBuilder(pref).append(ParseTheStringTaskConstants.DASH_STR).toString()));
            }
        });

        return result.toString();
    }

    private static String getKeyParentValue(StringBuilder str) {
        String[] split = str.toString().split(ParseTheStringTaskConstants.COMMA);
        return split[split.length - 1];
    }

    private static int getIndex(String stringWithoutParenthesis, String str) {
        return stringWithoutParenthesis.indexOf(str);
    }

    private static String getResultString(String stringWithoutParenthesis, String pref) {
        return new StringBuilder().append(pref).append(ParseTheStringTaskConstants.STR_SPACE)
                .append(stringWithoutParenthesis.replaceAll("\\s", ParseTheStringTaskConstants.EMPTY_STR))
                .append(System.getProperty("line.separator")).toString();
    }
}
