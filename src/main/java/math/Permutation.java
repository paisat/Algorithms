package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 14/12/15.
 */
public class Permutation {


    public List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums != null && nums.length != 0) {

            Arrays.sort(nums);
            List<Integer> list = new ArrayList<Integer>();
            for (int i : nums) {
                list.add(i);
            }

            permutationHelper(list, new ArrayList(), result);

        }

        return result;

    }

    public void permutationHelper(List<Integer> nums, List<Integer> permutation, List<List<Integer>> result) {

        if (nums.size() == 0 && !result.contains(permutation)) {
            result.add(permutation);
        } else {

            List<Integer> perm = new ArrayList<Integer>();
            perm.addAll(permutation);
            for (int i = 0; i < nums.size(); i++) {


                List<Integer> restNums = new ArrayList<Integer>();


                perm.add(nums.get(i));
                restNums.addAll(nums.subList(0, i));
                restNums.addAll(nums.subList(i + 1, nums.size()));

                permutationHelper(restNums, perm, result);


            }

        }

    }
}

