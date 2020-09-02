package parseTheStringTask;

public class ParseTheStringTask_v2 {

    public static void main(String[] args) {
        System.out.println("Result : ");
        String stringWithoutParenthesisOnTheSides =
                ParseTheStringTaskService.getStringWithoutParenthesisOnTheSides(ParseTheStringTaskConstants.STR);
        System.out.println(
                getParseResultStringValue(stringWithoutParenthesisOnTheSides, ParseTheStringTaskConstants.EMPTY_STR));
    }

    private static String getParseResultStringValue(String stringWithoutParenthesisOnTheSides, String pref) {
        StringBuilder str = new StringBuilder();

        int indexFirstParenthesis =
                stringWithoutParenthesisOnTheSides.indexOf(ParseTheStringTaskConstants.OPEN_PARENTHESIS);
        int indexClosingParenthesis = ParseTheStringTaskService
                .getClosingParenthesisPosition(stringWithoutParenthesisOnTheSides, indexFirstParenthesis);

        if (indexFirstParenthesis < 0 || indexClosingParenthesis < 0) {
            return ParseTheStringTaskService
                    .getResultString(ParseTheStringTaskService.removeSpaces().apply(stringWithoutParenthesisOnTheSides),
                            pref);
        }

        //append values before first parenthesis
        str.append(stringWithoutParenthesisOnTheSides, 0, indexFirstParenthesis);

        //get last value before first parenthesis
        String keyParentValue = ParseTheStringTaskService.getLastValue(str);

        //append values after last parenthesis
        str.append(stringWithoutParenthesisOnTheSides, indexClosingParenthesis + 1,
                stringWithoutParenthesisOnTheSides.length());

        StringBuilder result = new StringBuilder();

        ParseTheStringTaskService.getSortedValues(str).forEach(strValue -> {
            result.append(ParseTheStringTaskService.getResultString(strValue, pref));
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
