package parseTheStringTask;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ParseTheStringTask_v1 {
    public static void main(String[] args) {
        System.out.println("Result: ");
        parseAndPrintResult();
    }

    private static void parseAndPrintResult() {
        StringTokenizer st = new StringTokenizer(ParseTheStringTaskConstants.STR, "()");
        StringBuilder pref = new StringBuilder();
        boolean isFirst = true;

        while (st.hasMoreElements()) {
            String values = (String) st.nextElement();
            updatePref(pref, isFirst, values);
            String[] split = values.split(ParseTheStringTaskConstants.COMMA);
            Arrays.stream(split).filter(str -> !str.equals(ParseTheStringTaskConstants.EMPTY_STR)).forEach(str -> {
                System.out.println(pref.toString() + " "
                        + str.replaceAll("\\s", ParseTheStringTaskConstants.EMPTY_STR));
            });
            isFirst = false;
        }
    }

    private static void updatePref(StringBuilder pref, boolean isFirst, String values) {
        if (values.charAt(0) != ParseTheStringTaskConstants.COMMA_CHAR && !isFirst) {
            pref.append(ParseTheStringTaskConstants.DASH_STR);
        } else if (pref.length() != 0) {
            pref.deleteCharAt(pref.length() - 1);
        }
    }
}
