package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 10/11/15.
 * <p/>
 * Complexity : Catalan number
 */
public class GenerateParanthesis {

    public static void main(String[] args) {

        GenerateParanthesis obj = new GenerateParanthesis();

        System.out.println(obj.generateParenthesis(8));


    }


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();

        if (n > 0) {


            generateParenthesis(result, 0, new StringBuilder(" "), n, 0, 0);


        }


        return result;

    }


    private void generateParenthesis(List<String> result, int pos, StringBuilder parenthesis, int n, int open, int close) {

        if (close == n) {

            String res = new String(parenthesis);
            result.add(res.trim());

        } else {


            if (open > close) {

                parenthesis.setCharAt(pos, ')');
                parenthesis.append(' ');
                generateParenthesis(result, pos + 1, parenthesis, n, open, close + 1);
            }

            if (open < n) {
                parenthesis.setCharAt(pos, '(');
                parenthesis.append(' ');
                generateParenthesis(result, pos + 1, parenthesis, n, open + 1, close);
            }

        }

    }


}
