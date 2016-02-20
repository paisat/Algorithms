package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 15/12/15.
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p/>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p/>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p/>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p/>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
public class GrayCode {

    public static void main(String[] args) {

        GrayCode obj = new GrayCode();
        System.out.println(obj.grayCode(5));

        System.out.println(obj.grayCodes2(3));

        StackTraceElement traceElement[]= Thread.currentThread().getStackTrace();
        System.out.println(traceElement.length);

    }


    /**
     *
     * Time complexity : O(2^N)
     * */
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<Integer>();

        if (n >= 0) {

            result.add(0);

            int iterations=0;

            for (int i = 1; i <= n; i++) {
                iterations++;
                int front = 1 << (i - 1);
                int size = result.size();
                for (int j = size - 1; j >= 0; j--) {
                    iterations++;
                    result.add(result.get(j) + front);
                }
            }

            System.out.println(iterations);

        }

        return result;


    }


    public List<String> grayCodes2(int n) {

        List<String> grayCodes = new ArrayList<String>();

        if (n > 0) {

            grayCodes.add("0");
            grayCodes.add("1");

            for (int i = 2; i < (1 << n); i = i << 1) {

                for (int j = i - 1; j >= 0; j--) {
                    grayCodes.add(grayCodes.get(j));
                }

                int j = 0;
                for (j = 0; j < i; j++) {
                    StringBuilder sb = new StringBuilder(grayCodes.get(j));
                    sb.insert(0, "0");
                    grayCodes.set(j, sb.toString());
                }

                for (; j < 2 * i; j++) {

                    StringBuilder sb = new StringBuilder(grayCodes.get(j));
                    sb.insert(0, "1");
                    grayCodes.set(j, sb.toString());

                }
            }
        }
        return grayCodes;
    }
}
