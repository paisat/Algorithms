package math;

/**
 * Created by sarvothampai on 18/12/15.
 * <p/>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p/>
 * For example:
 * <p/>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelSheetConvertToTitle {

    public String convertToTitle(int n) {

        String result = "";

        if (n > 0) {

            while (n != 0) {

                result = ((char) ('A' + (n - 1) % 26)) + result;
                n = (n - 1) / 26;
            }
        }

        return result;

    }
}
