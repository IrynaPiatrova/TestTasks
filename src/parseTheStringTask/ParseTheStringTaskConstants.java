package parseTheStringTask;

public class ParseTheStringTaskConstants {
    protected static final String STR = "(id,created,employee(id,firstname,employeeType(id), lastname),location)";
    protected static final String STR2 = "(id,created,employee(id,firstname,employeeType2(id2, employee2(id2,firstname2,employeeType2(id2), lastname2, number2(id2))), lastname, number(id)),location)";
    protected static final String COMMA = ",";
    protected static final char COMMA_CHAR = ',';
    protected static final String DASH_STR = "-";
    protected static final String EMPTY_STR = "";
    protected static final String STR_SPACE = " ";
    protected static final String OPEN_PARENTHESIS = "(";
    protected static final char OPEN_PARENTHESIS_CHAR = '(';
}
