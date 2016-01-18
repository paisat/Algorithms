package math;

/**
 * Created by sarvothampai on 30/12/15.
 */
public class FactorialOfALargeNumber {


    public static void main(String[] args) {

        FactorialOfALargeNumber obj = new FactorialOfALargeNumber();
        System.out.println(obj.factorial(100));
    }


    public String factorial(int n) {

        String result = null;

        if (n > 0) {

            if (n == 0) {
                return "1";
            }

            if (n == 1) {
                return "1";
            }

            int res[] = new int[2000];

            res[0] = 1;
            int res_size = 0;


            for (int i = 2; i <= n; i++) {
                res_size = multiply(res, i, res_size);
            }

            result = "";

            for (int i = 0; i <= res_size; i++) {
                result = res[i] + result;
            }


        }

        return result;


    }


    private int multiply(int res[], int x, int res_size) {


        int carry = 0;
        for (int i = 0; i <= res_size; i++) {

            int product = res[i] * x + carry;
            res[i] = product % 10;
            carry = product / 10;
        }

        while (carry != 0) {
            res_size++;
            res[res_size] = carry % 10;
            carry = carry / 10;
        }

        return res_size;

    }

}
