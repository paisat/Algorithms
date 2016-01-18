package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 05/10/15.
 * <p/>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 *
 * =======
 *
 * Dont forget to sort
 * Dont forget to create a new array list before adding to result set
 *
 *
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        System.out.println(obj.combinationSum(new int[] { 2, 11 }, 11));
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();


        if (candidates != null && candidates.length != 0) {


            Arrays.sort(candidates);
            List<Integer> result = new ArrayList<Integer>();


            combinationUtil(target, 0, results, result, candidates);


        }


        return results;

    }

    private void combinationUtil(int target, int i, List<List<Integer>> results, List<Integer> result, int[] candidates) {

        if (target == 0) {

            if (!results.contains(result)) {
                List<Integer> res = new ArrayList<Integer>(result);
                results.add(res);
            }
            return;

        }

        for (int j = i; j < candidates.length; j++) {

            if (target < candidates[j]) {
                return;
            }

            result.add(candidates[j]);
            combinationUtil(target - candidates[j], j + 1, results, result, candidates);
            result.remove(result.size() - 1);

        }


    }
}
