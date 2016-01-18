package bitmanipulation;

/**
 * Created by sarvothampai on 11/12/15.
 */
public class IsNumberPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }
}
