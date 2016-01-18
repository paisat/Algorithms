package math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 09/11/15.
 *
 *
 * Value Increases by O(1.6^N)
 * Digits increase in n log (1.6)
 *
 */
public class FibonacciNumbers {


    public static void main(String[] args) {


        FibonacciNumbers obj = new FibonacciNumbers();

        System.out.println(obj.fibonacciLogNSolution(3).toString());
        //System.out.println(obj.fibonacciNumber(2000000).toString());
        // System.out.println(obj.fibonacciRecursive(10));
        // System.out.println(obj.fibonacciNumbersDynamicProgramming(2000).toString());

        List<List<Integer>> result =new ArrayList<List<Integer>>();





    }

    /*
    *
    * complexity is O(2 ^ N)
    *
    * */
    public int fibonacciRecursive(int n) {

        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);

    }

    public BigInteger fibonacciLogNSolution(int n) {

        Long millis = System.currentTimeMillis();

        BigInteger[][] fib = { { new BigInteger("1"), new BigInteger("1") }, { new BigInteger("1"), new BigInteger("0") } };

        if (n == 0) {
            return new BigInteger("0");
        }

        if (n == 1) {

            return new BigInteger("1");
        }

        BigInteger[][] result = power(fib, n - 1);


        System.out.println("time taken :" + (System.currentTimeMillis() - millis) / 1000.0);

        return result[0][0];

    }


    private BigInteger[][] power(BigInteger[][] x, int n) {


        BigInteger[][] result = { { new BigInteger("1"), new BigInteger("0") }, { new BigInteger("0"), new BigInteger("1") } };


        while (n > 0) {

            if (n % 2 == 0) {

                n = n / 2;

                x = multiply(x, x);


            } else {
                n--;
                result = multiply(result, x);
            }

        }

        return result;
    }

    private BigInteger[][] multiply(BigInteger[][] a, BigInteger b[][]) {

        BigInteger a100 = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));

        BigInteger a201 = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));

        BigInteger a310 = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));

        BigInteger a411 = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));

        BigInteger result[][] = new BigInteger[2][2];

        result[0][0] = a100;
        result[0][1] = a201;
        result[1][0] = a310;
        result[1][1] = a411;

        return result;

    }


    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public BigInteger fibonacciNumbersDynamicProgramming(int n) {


        BigInteger integer[] = new BigInteger[n + 1];

        integer[0] = new BigInteger("0");
        integer[1] = new BigInteger("1");


        if (n == 0) {
            return integer[0];
        }

        if (n == 1) {
            return integer[1];
        }

        for (int i = 2; i <= n; i++) {

            BigInteger c = integer[i - 2].add(integer[i - 1]);


            integer[i] = c;


        }

        return integer[n];

    }


    public BigInteger fibonacciNumber(int n) {

        Long millis = System.currentTimeMillis();
        if (n < 0) {
            return new BigInteger("-1");
        }

        if (n == 0) {
            return new BigInteger("0");
        }

        if (n == 1) {
            return new BigInteger("1");

        }


        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }

        System.out.println("time taken :" + (System.currentTimeMillis() - millis) / 1000.0);

        return b;

    }


}
