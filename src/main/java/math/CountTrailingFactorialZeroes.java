package math;

/**
 * Created by sarvothampai on 18/12/15.
 * <p/>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p/>
 * Note: Your solution should be in logarithmic time complexity.
 * <p/>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p/>
 * Time Complexity : Log(n)
 */
public class CountTrailingFactorialZeroes {

    public int trailingZeroes(int n) {
        if (n < 0)
            return -1;

        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }
}
