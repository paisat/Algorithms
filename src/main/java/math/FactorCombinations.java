package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 15/12/15.
 * <p/>
 * <p/>
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * Note:
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples:
 * input: 1
 * <p/>
 * input: 37
 * output:
 * []
 * input: 12
 * output:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 *
 * Time Complexity : O(N!)
 */
public class FactorCombinations {

    public static void main(String[] args) {

        int n1 = 1;

        FactorCombinations obj = new FactorCombinations();
        System.out.println(obj.getFactors(5));


    }

    public List<List<Integer>> getFactors(int n) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (n >= 1) {

            factorsHelper(n, result, new ArrayList<Integer>(), 2);
        }

        return result;

    }

    private void factorsHelper(int n, List<List<Integer>> result, List<Integer> factors, int start) {

        if (n <= 1) {
            if (factors.size() > 1) {
                result.add(new ArrayList<Integer>(factors));
            }
        } else {
            for (int i = start; i <= n; i++) {

                if (n % i == 0) {
                    factors.add(i);
                    factorsHelper(n / i, result, factors, i);
                    factors.remove(factors.size() - 1);
                }
            }
        }

    }

}

