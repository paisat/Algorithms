package dynamicprogramming;

/**
 * Created by sarvothampai on 10/11/15.
 * <p/>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p/>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p/>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p/>
 * The number of ways decoding "12" is 2.
 * <p/>
 * <p/>
 * Tips :
 * <p/>
 * Beware of inputs like "00000" and "0".
 * These inputs should return 0
 */
public class StringDecodeWays {

    public int numDecodings(String s) {

        int numOfDecodings = 0;

        if (s != null && s.length() != 0 && !s.equals("0")) {

            int length = s.length();

            int count[] = new int[length + 1];

            count[0] = 1;

            if (s.charAt(0) == '0') {
                count[1] = 0;
            } else {
                count[1] = 1;
            }


            for (int i = 2; i <= length; i++) {

                count[i] = 0;

                if (s.charAt(i - 1) != '0') {
                    count[i] = count[i - 1];
                }

                if (((s.charAt(i - 2) > '0' && s.charAt(i - 2) < '2') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                    count[i] += count[i - 2];
                }

            }

            numOfDecodings = count[length];


        }

        return numOfDecodings;


    }


    public int numDecodingsSpaceOptimized(String s) {

        int numOfDecodings = 0;

        if (s != null && s.length() != 0 && !s.equals("0")) {

            int length = s.length();

            int a = 1, b = 0;

            if (s.charAt(0) == '0') {
                b = 0;
            } else {
                b = 1;
            }

            int c = b;


            for (int i = 2; i <= length; i++) {

                c = 0;

                if (s.charAt(i - 1) != '0') {
                    c = b;
                }

                if (((s.charAt(i - 2) > '0' && s.charAt(i - 2) < '2') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                    c = a + b;

                }

                a = b;
                b = c;


            }

            numOfDecodings = c;


        }

        return numOfDecodings;


    }
}
