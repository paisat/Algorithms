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

    public static void main(String []args){

        GrayCode obj=new GrayCode();
        System.out.println(obj.grayCode(1));

    }

    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<Integer>();

        if (n >= 0) {

            result.add(0);

            for (int i = 1; i <= n; i++) {
                int front = 1 << (i - 1);
                int size = result.size();
                for (int j = size - 1; j >= 0; j--) {
                    result.add(result.get(j) + front);
                }
            }

        }

        return result;


    }
}
