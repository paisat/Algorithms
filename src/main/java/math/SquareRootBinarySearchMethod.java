package math;

/**
 * Created by sarvothampai on 05/10/15.
 * <p/>
 * Complexity log(n)
 * <p/>
 * high<=low . Will fail if high<low
 */
public class SquareRootBinarySearchMethod {

    public static void main(String[] args) {

        SquareRootBinarySearchMethod obj = new SquareRootBinarySearchMethod();
        System.out.println(obj.mySqrt(2147483647));
    }

    public int mySqrt(int x) {

        long high = x;
        long low = 0;

        long ans = 0;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (mid * mid == x) {
                return (int) mid;
            }

            if (mid * mid < x) {

                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }

        }


        return (int) ans;
    }


}
