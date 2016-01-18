package math;

/**
 * Created by sarvothampai on 18/12/15.
 * <p/>
 * Related to question Excel Sheet Column Title
 * <p/>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p/>
 * For example:
 * <p/>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        int result = 0;

        if (s != null && s.length() != 0) {

            for (int i = 0; i < s.length(); i++) {

                result = result * 26 + (s.charAt(i) - 'A') + 1;

            }
        }

        return result;

    }
}
