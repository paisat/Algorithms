package Strings;

import java.util.LinkedList;

/**
 * Created by sarvothampai on 11/11/15.
 * <p/>
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p/>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * <p/>
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyPath {

    public static void main(String[] args) {


        SimplifyPath obj = new SimplifyPath();
        System.out.println(obj.simplifyPath("/."));
        //System.out.println(obj.simplifyPath())
    }

    public String simplifyPath(String path) {

        String result = null;

        if (path != null && path.length() != 0) {

            LinkedList<String> stack = new LinkedList<String>();

            String[] p = path.split("/");

            for (String s : p) {

                if (s.equals("") || s.equals(".")) {
                    continue;
                }

                if (s.equals("..")) {

                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                } else {

                    stack.push(s);
                }

            }

            if (stack.isEmpty()) {
                result = "/";
            } else {
                result = "";
                while (!stack.isEmpty()) {
                    result = result + "/" + stack.removeLast();

                }
            }

        }

        return result;

    }
}
