package parseTheStringTask;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ParseTheStringTask_v1 {
    public static void main(String[] args) {
        System.out.println("Result: ");
        parseAndPrintResult(ParseTheStringTaskConstants.STR);
    }

    private static void parseAndPrintResult(String string) {
        StringTokenizer st = new StringTokenizer(ParseTheStringTaskService.removeSpaces().apply(string), "()");
        StringBuilder pref = new StringBuilder();
        boolean isFirst = true;

        while (st.hasMoreElements()) {
            String values = (String) st.nextElement();
            updatePref(pref, isFirst, values);
            Arrays.stream(values.split(ParseTheStringTaskConstants.COMMA))
                    .filter(str -> !str.equals(ParseTheStringTaskConstants.EMPTY_STR))
                    .forEach(str -> printValueWithPref(pref, str));

            isFirst = false;
        }
    }

    private static void printValueWithPref(StringBuilder pref, String str) {
        System.out.println(new StringBuilder(pref)
                .append(ParseTheStringTaskConstants.STR_SPACE)
                .append(str)
                .toString());
    }

    private static void updatePref(StringBuilder pref, boolean isFirst, String values) {
        boolean isFirstCharComma = values.charAt(0) != ParseTheStringTaskConstants.COMMA_CHAR;
        if (isFirstCharComma && !isFirst) {
            pref.append(ParseTheStringTaskConstants.DASH_STR);
        } else if (pref.length() != 0) {
            pref.deleteCharAt(pref.length() - 1);
        }
    }
}
