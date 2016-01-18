package math;

/**
 * Created by sarvothampai on 12/12/15.
 */
public class ReverseDigit {

    public static void main(String[] args) {

        ReverseDigit obj = new ReverseDigit();

        System.out.println(obj.reverse(-2147483648));

    }

    public int reverse(int x) {

        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        boolean negative = (x < 0) ? true : false;

        x = Math.abs(x);

        int result = 0;

        while (x != 0) {

            int r = x % 10;
            x = x / 10;


            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            result = result * 10 + r;

        }

        result = (negative) ? result * -1 : result;


        return result;

    }
}
