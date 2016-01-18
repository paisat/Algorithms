package math;

/**
 * Created by sarvothampai on 05/10/15.
 * <p/>
 * Time Complexity : O(log n)
 */
public class PowerFunction {


    public static void main(String[] args) {
        PowerFunction obj = new PowerFunction();

        System.out.println(obj.myPow(-3, 3));
    }

    public double myPow(double x, int n) {
        double result = 1;
        int pow = Math.abs(n);

        while (pow > 0) {

            if (pow % 2 == 0) {
                pow = pow / 2;
                x = x * x;
            } else {
                pow--;
                result = result * x;
            }

        }

        return ((n < 0) ? 1 / result : result);

    }
}
