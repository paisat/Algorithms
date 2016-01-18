package Strings;

import java.util.Stack;

/**
 * Created by sarvothampai on 29/09/15.
 *
 *
 * Tips : Take care of divide by zero.
 * Extract a number until its space or any other operator.
 *
 * + , - and * , / have same operator precedence.
 *
 * Postfix expression evaluation
 *
 *
 *
 *
 *
 */


public class EvaluateExpression {


    public static void main(String[] args) {
        EvaluateExpression expression = new EvaluateExpression();
        System.out.println(expression.calculate("1+2*5/3+6/4*2"));

    }


    public int calculate(String s) {

        Integer result = null;
        if (s != null && s.length() != 0) {

            Stack<Integer> valueStack = new Stack<Integer>();
            Stack<Character> operatorStack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {

                char var = s.charAt(i);
                if (var != ' ') {

                    if (isRightParenthesis(var)) {


                        while (!operatorStack.empty() &&
                                operatorStack.peek() != '(') {

                            Integer operand2 = valueStack.pop();
                            Integer operand1 = valueStack.pop();
                            Integer value = compute(operand1, operand2, operatorStack.pop());

                            valueStack.add(value);


                        }

                        operatorStack.pop();


                    } else if (!isOperator(var)) {

                        String value = "";
                        while ( i<=s.length()-1 && s.charAt(i) != ' ' && !isOperator(s.charAt(i)) ) {
                            value = value + s.charAt(i);
                            i++;
                        }

                        i--;

                        valueStack.add(Integer.valueOf(value));
                    } else {

                        while (!operatorStack.empty() && !isLeftParenthesis(var) && compareOperators
                                (operatorStack.peek(), var) >= 0) {

                            Integer operand2 = valueStack.pop();
                            Integer operand1 = valueStack.pop();
                            Integer value = compute(operand1, operand2, operatorStack.pop());
                            valueStack.add(value);
                        }

                        operatorStack.add(var);

                    }

                }

            }


            while (!operatorStack.empty()) {

                Integer operand2 = valueStack.pop();
                Integer operand1 = valueStack.pop();
                Integer value = compute(operand1, operand2, operatorStack.pop());

                valueStack.add(value);


            }


            result = valueStack.pop();

        }

        return result;


    }

    private boolean isOperator(char a) {

        switch (a) {

            case '*':
                return true;

            case '+':
                return true;

            case '/':
                return true;

            case '-':
                return true;

            case '(':
                return true;

            case ')':
                return true;

        }

        return false;

    }

    private Integer compareOperators(char operator1, char operator2) {

        Integer precedence1 = getOperatorPrecedenceValue(operator1);
        Integer precedence2 = getOperatorPrecedenceValue(operator2);

        return ((precedence1 == precedence2) ? 0 : (precedence1 > precedence2) ? 1 : -1);

    }


    private Integer getOperatorPrecedenceValue(char operator) {

        switch (operator) {


            case '/':
                return 9;
            case '*':
                return 9;
            case '+':
                return 8;
            case '-':
                return 8;

        }

        return 0;
    }

    private Integer compute(Integer operand1, Integer operand2, char operator) {


        switch (operator) {

            case '*':
                return (Integer.valueOf(operand1) * Integer.valueOf(operand2));

            case '+':
                return (Integer.valueOf(operand1) + Integer.valueOf(operand2));

            case '/':
                return (Integer.valueOf(operand1) / Integer.valueOf(operand2));

            case '-':
                return (Integer.valueOf(operand1) - Integer.valueOf(operand2));

        }

        return 0;


    }

    private boolean isLeftParenthesis(char operator) {

        return (isOperator(operator) && operator == '(');
    }

    private boolean isRightParenthesis(char operator) {

        return (isOperator(operator) && operator == ')');
    }

}

