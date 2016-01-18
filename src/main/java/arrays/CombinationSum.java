package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 05/10/15.
 * <p/>
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 *
 * Time Complexity : O(n!)
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[] { 92,71,89,74,102,91,70,119,86,116,114,106
                ,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73}, 310));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();


        if (candidates != null && candidates.length != 0) {


            Arrays.sort(candidates);
            List<Integer> result = new ArrayList<Integer>();


            combinationUtil(target, 0, results, result, candidates);


        }


        return results;

    }

    public void combinationUtil(int target, int i, List<List<Integer>> results, List<Integer> result, int[] candidates) {

        if (target == 0) {
            List<Integer> res = new ArrayList<Integer>(result);
            results.add(res);
            return;
        }

        for (int j = 0; j < candidates.length; j++) {

            if (target < candidates[j]) {
                return;
            }

            result.add(candidates[j]);
            combinationUtil(target - candidates[j], j, results, result, candidates);
            result.remove(result.size() - 1);

        }


    }

}
