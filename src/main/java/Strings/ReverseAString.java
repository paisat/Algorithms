package Strings;

/**
 * Created by sarvothampai on 21/10/15.
 */
public class ReverseAString {

    public static void main(String args[]) {

        String input = "abc";

        ReverseAString obj = new ReverseAString();

        System.out.println(obj.reverseStringIteratively(input));
        System.out.println(obj.reverseStringIteratively("abcd"));
        System.out.println(obj.reverseRecursively(new StringBuilder(input), 0));

    }

    private String reverseRecursively(StringBuilder string, int i) {

        if (i == (string.length() - 1) / 2) {
            return string.toString();
        }

        char temp = string.charAt(i);
        string.setCharAt(i, string.charAt(string.length() - 1 - i));
        string.setCharAt(string.length() - 1 - i, temp);

        return reverseRecursively(string, i + 1);

    }


    static void rvereseArray(int arr[], int start, int end) {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start + 1, end - 1);
    }

    private String reverseStringIteratively(String s) {

        if (s != null && s.length() != 0) {

            int length = s.length();

            int i = 0;
            int j = length - 1;

            StringBuilder string = new StringBuilder(s);

            for (int k = 0; k <= (length - 1) / 2; k++) {
                char temp = string.charAt(k);
                string.setCharAt(k, string.charAt(j - k));
                string.setCharAt(j - k, temp);
            }

            s = string.toString();
        }


        return s;

    }
}
