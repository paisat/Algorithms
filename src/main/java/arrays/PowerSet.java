package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 16/10/15.
 */
public class PowerSet {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<List<Integer>>();

        if (nums != null & nums.length != 0) {

            int n = nums.length;

            Arrays.sort(nums);

            for (int i = 0; i <= Math.pow(2, n) - 1; i++) {

                List<Integer> subset = new ArrayList<Integer>();

                for (int j = 0; j < n; j++) {

                    if ((i & 1 << j) != 0) {
                        subset.add(nums[j]);
                    }

                }

                subsets.add(subset);

            }

        }

        return subsets;

    }
}
