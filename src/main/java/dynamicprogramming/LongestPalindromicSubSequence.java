package dynamicprogramming;

/**
 * Created by sarvothampai on 08/01/16.
 * <p/>
 * Time Complexity O(N^2)
 */
public class LongestPalindromicSubSequence {

    public int calculate1(char[] str) {
        int T[][] = new int[str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            T[i][i] = 1;
        }
        for (int l = 2; l <= str.length; l++) {
            for (int i = 0; i < str.length - l + 1; i++) {
                int j = i + l - 1;
                if (l == 2 && str[i] == str[j]) {
                    T[i][j] = 2;
                } else if (str[i] == str[j]) {
                    T[i][j] = T[i + 1][j - 1] + 2;
                } else {
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length - 1];
    }


    public static void main(String args[]) {
        LongestPalindromicSubSequence lps = new LongestPalindromicSubSequence();
        String str = "agbdba";
        int r2 = lps.calculate1(str.toCharArray());
        System.out.print(r2);
    }
}
