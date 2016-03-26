package dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 26/03/16.
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p/>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p/>
 * The matching should cover the entire input string (not partial).
 * <p/>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p/>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildCardMathchingProblem {


    @Test
    public void test() {

        WildCardMathchingProblem obj = new WildCardMathchingProblem();
        Assert.assertTrue(obj.isMatch("aa", "aa"));
        Assert.assertTrue(obj.isMatch("", ""));
        Assert.assertTrue(obj.isMatch("ho", "******ho"));

    }


    /**
     *
     * Time Complexity : O( string Length  * pattern length )
     * Space Complexity : O( string length * pattern length )
     *
     * */
    public boolean isMatch(String s, String p) {

        if (s != null && p != null) {


            boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
            char pattern[] = p.toCharArray();


            //Required for inputs like ******ho which is equivalent to *ho

            if (p.length() != 0) {
                int index = 0;

                for (int i = 1; i < p.length(); i++) {
                    if (pattern[index] == '*' && pattern[i] == '*') {
                        continue;
                    } else {
                        ++index;
                        pattern[index] = pattern[i];
                    }
                }

                p = new String(pattern);
                p = p.substring(0, index + 1);

            }


            dp[0][0] = true;

            if (p.length() != 0 && p.charAt(0) == '*') {
                dp[0][1] = true;
            }


            for (int i = 1; i <= s.length(); i++) {

                for (int j = 1; j <= p.length(); j++) {

                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }

                }
            }

            return dp[s.length()][p.length()];

        }
        return false;

    }



}
