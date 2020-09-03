package parseTheStringTask;

import java.util.TreeMap;

public class ParseTheStringTask_v3 {

    public static void main(String[] args) {
        System.out.println("Result : ");
        String string =
                ParseTheStringTaskService.getStringWithoutParenthesisOnTheSides(ParseTheStringTaskConstants.STR2);
        System.out.println(gerResult(getTree(ParseTheStringTaskService.removeSpaces().apply(string),
                ParseTheStringTaskConstants.EMPTY_STR)));
    }

    private static TreeMap<String, String> getTree(String string, String pref) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        int indexFirstParenthesis = string.indexOf(ParseTheStringTaskConstants.OPEN_PARENTHESIS);
        int indexFirstComma = string.indexOf(ParseTheStringTaskConstants.COMMA);

        //when there's only one word left
        if (indexFirstParenthesis < 0 && indexFirstComma < 0) {
            treeMap.put(pref + string, "");
            return treeMap;
        }

        while (string != null) {
            indexFirstComma = string.indexOf(ParseTheStringTaskConstants.COMMA);
            String strBeforeComma = indexFirstComma > 0 ? string.substring(0, indexFirstComma) : string;
            int indexParenthesis = strBeforeComma.indexOf('(');
            string =
                    getSubstringAndUpdateTree(string, pref, treeMap, indexFirstComma, strBeforeComma, indexParenthesis);
        }

        return treeMap;
    }

    private static String getSubstringAndUpdateTree(String string, String pref, TreeMap<String, String> treeMap,
                                                    int indexFirstComma, String strBeforeComma, int indexParenthesis) {
        if (indexParenthesis >= 0) { // if string has parenthesis
            int closingParenthesis = ParseTheStringTaskService.getClosingParenthesisPosition(string, indexParenthesis);
            String strBetweenParenthesis = string.substring(indexParenthesis + 1, closingParenthesis);

            treeMap.put(pref + string.substring(0, indexParenthesis),
                    gerResult(getTree(strBetweenParenthesis, ParseTheStringTaskService.getNewPref(pref))));

            string = getSubstringByIndex(string, closingParenthesis); //remove what we added to tree
        } else if (!ParseTheStringTaskConstants.EMPTY_STR.equals(strBeforeComma)) {
            treeMap.put(pref + strBeforeComma, ParseTheStringTaskConstants.EMPTY_STR);
            string = indexFirstComma < 0 ? null
                    : getSubstringByIndex(string, indexFirstComma);
        } else {
            string = null;
        }
        return string;
    }

    private static String getSubstringByIndex(String string, int index) {
        string = string.substring(index + 1);
        string = getStringWithoutCommaAtTheBeginning(string);
        return string;
    }

    private static String getStringWithoutCommaAtTheBeginning(String string) {
        if (!ParseTheStringTaskConstants.EMPTY_STR.equals(string)
                && string.toCharArray()[0] == ParseTheStringTaskConstants.COMMA_CHAR) {
            string = string.substring(1);
        }
        return string;
    }

    private static String gerResult(TreeMap<String, String> treeMap) {
        StringBuilder result = new StringBuilder();
        treeMap.forEach((k, v) -> {
            result.append(k).append(System.getProperty("line.separator"));
            if (!ParseTheStringTaskConstants.EMPTY_STR.equals(v)) {
                result.append(v);
                addSeparatorIfNeede(result);
            }
        });
        return result.toString();
    }

    private static void addSeparatorIfNeede(StringBuilder result) {
        if (result.toString().toCharArray()[result.length() - 1] != '\n') {
            result.append(System.getProperty("line.separator"));
        }
    }
}
