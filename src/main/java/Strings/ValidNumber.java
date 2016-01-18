package Strings;

/**
 * Created by sarvothampai on 20/12/15.
 * <p/>
 * Validate if a given string is numeric.
 * <p/>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 * <p/>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated.
 * If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p/>
 *
 * Time Complexity : O(N)
 */
public class ValidNumber {

    public boolean isNumber(String s) {

        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean numberSeen = false;
        boolean pointerSeen = false;
        boolean eSeen = false;
        boolean numberSeenAfterE = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {

                if (eSeen) {
                    numberSeenAfterE = true;
                } else {
                    numberSeen = true;
                }

            } else if (ch == '.') {

                if (pointerSeen || eSeen) {
                    return false;
                }

                pointerSeen = true;

            } else if (ch == 'e') {
                if (eSeen) {
                    return false;
                }
                eSeen = true;

            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }

        }

        if (eSeen) {
            return numberSeen && numberSeenAfterE;
        } else {
            return numberSeen;
        }

    }

}
