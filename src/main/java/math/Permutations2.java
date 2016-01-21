package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 14/12/15.
 * <p/>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * <p/>
 * <p/>
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * <p/>
 * Time Complexity : O(N!)
 *
 * 
 * Yes, the reason of sorting is to skip duplicates. Take [1, 2, 2, 3] for example, when pos equals 0, we have below cases

 (1,2,2,3) (pos = 0, i = 0)

 (2,1,2,3) (pos = 0, i = 1)

 (2,1,2,3) (pos = 0, i =2) skipped, since array[0]=array[2]; in other words, its subset (1,2,3) is the same as the second case (pos = 0, i=1)

 (3,1,2,2) (pos = 0, i =3)

 As we can see, the subset of the above four cases are still sorted. Amazing! Recursion continues.
 *
 */
public class Permutations2 {

    public static void main(String[] args) {

        Permutations2 obj = new Permutations2();

        obj.permuteUnique(new int[] { 1, 1 });


    }

    public List<List<Integer>> permuteUnique(int[] nums) {


        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums != null && nums.length != 0) {

            Arrays.sort(nums);
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i : nums) {
                list.add(i);
            }

            permutationHelper(list, new ArrayList<Integer>(), result);

        }

        return result;

    }

    public void permutationHelper(List<Integer> nums, List<Integer> permutation, List<List<Integer>> result) {

        if (nums.size() == 0) {
            List<Integer> perm=new ArrayList<Integer>();
            perm.addAll(permutation);
            result.add(perm);
        } else {

            for (int i = 0; i < nums.size(); i++) {

                if (i > 0 && nums.get(i - 1).equals(nums.get(i))) {
                    continue;
                }

                int element=nums.get(i);
                permutation.add(element);
                nums.remove(i);
                permutationHelper(nums, permutation, result);
                nums.add(i,element);
                permutation.remove(permutation.size() - 1);
            }

        }

    }

    public void permutationHelper2(List<Integer> nums, int pos, List<List<Integer>> result) {

        if (pos == nums.size()) {
            result.add(new ArrayList<Integer>(nums));
        } else {

            for (int i = pos; i < nums.size(); i++) {

                if (i != pos && nums.get(i) == nums.get(pos)) {
                    continue;
                }

                swap(nums, pos, i);
                permutationHelper2(nums, pos + 1, result);
                swap(nums, pos, i);
            }

        }

    }

    private void swap(List<Integer> nums, int pos1, int pos2) {
        int temp = nums.get(pos1);
        nums.set(pos1, nums.get(pos2));
        nums.set(pos2, temp);
    }

}
