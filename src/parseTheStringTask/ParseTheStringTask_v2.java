package parseTheStringTask;

public class ParseTheStringTask_v2 {

    public static void main(String[] args) {
        System.out.println("Result : ");
        parseAndPrintResult(ParseTheStringTaskConstants.STR);
    }

    private static void parseAndPrintResult(String string) {
        string = ParseTheStringTaskService.getStringWithoutParenthesisOnTheSides(ParseTheStringTaskConstants.STR);
        System.out.println(getParseResultStringValue(ParseTheStringTaskService.removeSpaces().apply(string),
                ParseTheStringTaskConstants.EMPTY_STR));
    }

    private static String getParseResultStringValue(String stringWithoutParenthesisOnTheSides, String pref) {
        StringBuilder strOfOneLevel = new StringBuilder();

        int indexFirstParenthesis =
                stringWithoutParenthesisOnTheSides.indexOf(ParseTheStringTaskConstants.OPEN_PARENTHESIS);
        int indexClosingParenthesis = ParseTheStringTaskService
                .getClosingParenthesisPosition(stringWithoutParenthesisOnTheSides, indexFirstParenthesis);

        if (indexFirstParenthesis < 0 || indexClosingParenthesis < 0) {
            return ParseTheStringTaskService.getResultStringWithSeparator(stringWithoutParenthesisOnTheSides, pref);
        }

        //append values before first parenthesis
        strOfOneLevel.append(stringWithoutParenthesisOnTheSides, 0, indexFirstParenthesis);

        //get last value before first parenthesis
        String keyParentValue = ParseTheStringTaskService.getLastValue(strOfOneLevel.toString());

        //append values after last parenthesis
        strOfOneLevel.append(stringWithoutParenthesisOnTheSides, indexClosingParenthesis + 1,
                stringWithoutParenthesisOnTheSides.length());

        return getResultString(stringWithoutParenthesisOnTheSides, pref, strOfOneLevel.toString(),
                indexFirstParenthesis, indexClosingParenthesis, keyParentValue);
    }

    private static String getResultString(String stringWithoutParenthesisOnTheSides, String pref, String str,
                                          int indexFirstParenthesis, int indexClosingParenthesis,
                                          String keyParentValue) {
        StringBuilder result = new StringBuilder();

        ParseTheStringTaskService.getSortedValues(str).forEach(strValue -> {
            result.append(ParseTheStringTaskService.getResultStringWithSeparator(strValue, pref));
            if (keyParentValue != null && keyParentValue.equals(strValue)) {
                String hierarchicalSubstring = stringWithoutParenthesisOnTheSides
                        .substring(indexFirstParenthesis + 1, indexClosingParenthesis);
                result.append(
                        getParseResultStringValue(hierarchicalSubstring, ParseTheStringTaskService.getNewPref(pref)));
            }
        });

        return result.toString();
    }
}
