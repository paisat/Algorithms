package tree;

import java.util.Stack;

/**
 * Created by sarvothampai on 16/01/16.
 * <p/>
 * find_depth('(00)') -> 0
 * find_depth('((00)0)') -> 1
 * find_depth('((00)(00))') -> 1
 * find_depth('((00)(0(00)))') -> 2
 * find_depth('((00)(0(0(00))))') -> 3
 * find_depth('x') -> -1
 * find_depth('0') -> -1
 * find_depth('()') -> -1
 * find_depth('(0)') -> -1
 * find_depth('(00)x') -> -1
 * find_depth('(0p)') -> -1
 */
public class FindDepth {


    public static void main(String[] args) {

        FindDepth obj = new FindDepth();
        System.out.println(obj.findDepth("(00)"));
        System.out.println(obj.findDepth("((00)0)"));
        System.out.println(obj.findDepth("((00)(00))"));
        System.out.println(obj.findDepth("((00)(0(00)))"));
        System.out.println(obj.findDepth("((00)(0(0(00))))"));
        System.out.println(obj.findDepth("x"));
        System.out.println(obj.findDepth("0"));
        System.out.println(obj.findDepth("((00)0((0(00))))"));

    }


    public int findDepth(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }

        Stack<Character> parenthesisStack = new Stack<Character>();
        Stack<Integer> nodeCount = new Stack<Integer>();

        int maxDepth = 0;


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ')' && ch != '(' && ch != '0') {
                return -1;
            }

            if (ch == '(') {
                parenthesisStack.add(ch);
                if (nodeCount.isEmpty()) {
                    nodeCount.add(0);
                } else {
                    int count = nodeCount.pop();
                    count++;
                    nodeCount.push(count);
                    nodeCount.push(0);
                }
                maxDepth = Math.max(maxDepth, parenthesisStack.size());
            } else if (ch == ')') {
                if (parenthesisStack.isEmpty()) {
                    return -1;
                }

                if (nodeCount.isEmpty() || nodeCount.peek() != 2) {
                    return -1;
                }

                nodeCount.pop();
                parenthesisStack.pop();
            } else {

                if (nodeCount.isEmpty()) {
                    return -1;
                }

                int top = nodeCount.pop();

                if (top == 2) {
                    return -1;
                }
                top++;
                nodeCount.add(top);

            }


        }

        return (parenthesisStack.isEmpty() && nodeCount.isEmpty() ) ? maxDepth - 1 : -1;


    }


}
