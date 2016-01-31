package Strings;

import java.util.Stack;

/**
 * Created by sarvothampai on 21/10/15.
 * <p/>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * <p>
 * Time Complexity :
 */


/**
 *
 * Time Complexity : O(N)
 *
 * */
public class ValidParenthesis {

    public boolean isValid(String s) {

        if (s != null && s.length() != 0) {


            int length = s.length();

            Stack<Character> paraStack = new Stack<Character>();

            for (int i = 0; i < length; i++) {

                char para = s.charAt(i);

                if (para == '(' || para == '[' || para == '{') {

                    paraStack.add(para);
                } else if (para == ')' || para == ']' || para == '}') {

                    if (paraStack.isEmpty()) {
                        return false;
                    }

                    if (para == ')' && paraStack.peek() != '(') {
                        return false;
                    } else if (para == ']' && paraStack.peek() != '[') {
                        return false;
                    } else if (para == '}' && paraStack.peek() != '{') {
                        return false;
                    }

                    paraStack.pop();

                }


            }

            if (!paraStack.isEmpty()) {
                return false;
            }

            return true;

        }

        return false;

    }


    public boolean matched(String s) {
        // Implementation here
        int len = s.length();
        if (len == 0) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }


    /**
     * Just replace all parenthesis.
     * The Final string should be of length zero
     * <p>
     * Not so efficient
     * <p>
     * Might go upto O(N^2);
     */
    public boolean isValid2(String s) {
        int length;

        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while (length != s.length());

        return s.length() == 0;
    }
}
