package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 15/12/15.
 */
public class Combination {

    public List<List<Integer>> combine(int n, int k) {


        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (n > 0 && k > 0) {
            combinationHelper(0, results, k, new ArrayList<Integer>(), n);
        }

        return results;

    }


    private void combinationHelper(int start, List<List<Integer>> results, int k, List<Integer> combination, int n) {

        if (combination.size() == k) {
            results.add(combination);
        } else {

            for (int i = start; i <= n; i++) {

                List<Integer> combi = new ArrayList<Integer>();
                combi.addAll(combination);

                combi.add(i);

                combinationHelper(start + 1, results, k, combi, n);


            }
        }


    }
}
