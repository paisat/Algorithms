package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 20/12/15.
 * <p/>
 * Write a program to find the n-th ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 * <p/>
 * Time Complexity : O(N)
 *
 *
 */
public class NThUglyNumber {

    public int nthUglyNumber(int n) {

        if (n <= 0) {
            return 0;
        }

        int a = 0, b = 0, c = 0;

        List<Integer> table = new ArrayList<Integer>();
        table.add(1);

        while (table.size() < n) {

            int nextVal = Math.min(table.get(a) * 2, Math.min(table.get(b) * 3, table.get(c) * 5));

            table.add(nextVal);

            if (nextVal == table.get(a) * 2) {
                a++;
            }

            if (nextVal == table.get(b) * 3) {
                b++;
            }

            if (nextVal == table.get(c) * 5) {
                c++;
            }

        }

        return (table.get(table.size() - 1));

    }
}
