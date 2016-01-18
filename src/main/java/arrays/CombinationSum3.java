package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 15/10/15.
 * <p/>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p/>
 * Ensure that numbers within the set are sorted in ascending order.
 */
public class CombinationSum3 {

    public static void main(String []args){

        CombinationSum3 obj=new CombinationSum3();

        System.out.println(obj.combinationSum3(3,28));


    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (k != 0) {

            combinationUtil(results, new ArrayList<Integer>(), k, n, 1);
        }

        return results;


    }


    private void combinationUtil(List<List<Integer>> results, List<Integer> result, int k, int target, int j) {

        if (k == 0 && target == 0) {

            List<Integer> res = new ArrayList<Integer>(result);

            results.add(res);
        }

        for (int i = j; i <= 9; i++) {

            if (target < i) {
                return;
            }

            result.add(i);
            combinationUtil(results, result, k - 1, target - i, i+1);
            result.remove(result.size() - 1);
        }

    }

}
