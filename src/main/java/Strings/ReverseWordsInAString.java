package Strings;

/**
 * Created by sarvothampai on 21/10/15.
 * Given an input string, reverse the string word by word.
 * <p/>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p/>
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * <p/>
 * click to show clarification.
 * <p/>
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {

        String result = "";

        if (s != null && s.length() != 0) {


            s = s.trim();
            int length = s.length();
            int i = length - 1;

            while (i >= 0) {

                String word = "";

                while (i >= 0 && s.charAt(i) != ' ') {
                    word = s.charAt(i) + word;
                    i--;
                }

                result = result + word + " ";

                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }

            }


            result = result.trim();

        }

        return result;

    }
}
