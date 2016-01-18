package stacks;

import java.util.Stack;

/**
 * Created by sarvothampai on 17/12/15.
 * <p/>
 * <p/>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        int result = 0;
        if (tokens != null && tokens.length != 0) {

            Stack<Integer> value = new Stack<Integer>();

            for (int i = 0; i < tokens.length; i++) {

                if (tokens[i].equals("*")) {
                    value.push(value.pop() * value.pop());
                } else if (tokens[i].equals("+")) {
                    value.push(value.pop() + value.pop());
                } else if (tokens[i].equals("-")) {
                    value.push(-value.pop() + value.pop());
                } else if (tokens[i].equals("/")) {

                    int n1 = value.pop();
                    int n2 = value.pop();
                    value.push(n2 / n1);

                } else {
                    value.push(Integer.parseInt(tokens[i]));

                }


            }

            result = value.pop();


        }

        return result;

    }
}
