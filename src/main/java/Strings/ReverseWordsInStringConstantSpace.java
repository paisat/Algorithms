package Strings;

/**
 * Created by sarvothampai on 10/11/15.
 * <p/>
 * Question: Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 *
 *
 * Time Complexity : O(N)
 *
 */
public class ReverseWordsInStringConstantSpace {

    public static void main(String[] args) {

        ReverseWordsInStringConstantSpace obj = new ReverseWordsInStringConstantSpace();

        System.out.println(obj.reverse("the sky is blue"));

    }


    public String reverse(String s) {


        String reverse = null;

        if (s != null && s.length() != 0) {


            s = s.trim();
            int length = s.length();
            s = reverseString(s, 0, length - 1);


            int end = length - 1;

            for (int i = length - 1; i >= 0; i--) {


                if (s.charAt(i) == ' ' || i == 0) {

                    int start = (i == 0) ? 0 : i + 1;

                    s = reverseString(s, start, end);
                    end = i - 1;

                }
            }

            reverse = s;


        }

        return reverse;

    }


    private String reverseString(String s, int left, int right) {

        StringBuilder sb = new StringBuilder(s);
        int length = right - left + 1;

        for (int i = 0; i < length / 2; i++) {

            char temp = sb.charAt(left + i);

            sb.setCharAt(left + i, sb.charAt(right - i));
            sb.setCharAt(right - i, temp);


        }

        return sb.toString();

    }

}
