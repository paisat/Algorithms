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
 * Time Complexity : O(N! / r!  )
 * <p/>
 * Where r is unique repetitions.
 * <p/>
 * <p/>
 * <p/>
 * Yes, the reason of sorting is to skip duplicates. Take [1, 2, 2, 3] for example, when pos equals 0, we have below cases
 * <p/>
 * (1,2,2,3) (pos = 0, i = 0)
 * <p/>
 * (2,1,2,3) (pos = 0, i = 1)
 * <p/>
 * (2,1,2,3) (pos = 0, i =2) skipped, since array[0]=array[2]; in other words, its subset (1,2,3) is the same as the second case (pos = 0, i=1)
 * <p/>
 * (3,1,2,2) (pos = 0, i =3)
 * <p/>
 * As we can see, the subset of the above four cases are still sorted. Amazing! Recursion continues.
 */
public class Permutations2 {

    public static void main(String[] args) {

        Permutations2 obj = new Permutations2();

        System.out.println(obj.permuteUnique(new int[] { 1, 2, 3,4 }));

        System.out.println(obj.permutationsWithRepititions(new int[] { 2, 3, 4 }, 2));
        System.out.println(obj.permutationsWithRepititions2(new int[] { 2, 3, 4 }, 2));


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
            List<Integer> perm = new ArrayList<Integer>();
            perm.addAll(permutation);
            result.add(perm);
        } else {

            for (int i = 0; i < nums.size(); i++) {

                if (i > 0 && nums.get(i - 1).equals(nums.get(i))) {
                    continue;
                }

                int element = nums.get(i);
                permutation.add(element);
                nums.remove(i);
                permutationHelper(nums, permutation, result);
                nums.add(i, element);
                permutation.remove(permutation.size() - 1);
            }

        }

    }

    public void permutationHelper2(int nums[], int pos, List<List<int[]>> result) {

        if (pos == nums.length) {
            result.add(Arrays.asList(nums));
        } else {

            for (int i = pos; i < nums.length; i++) {

                if (i != pos && nums[i] == nums[pos]) {
                    continue;
                }

                swap(nums, pos, i);
                permutationHelper2(nums, pos + 1, result);
                swap(nums, pos, i);
            }

        }

    }

    private void swap(int nums[], int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }


    /**
     * Number of permutaions with repitition = n^k
     */

    public List<List<Integer>> permutationsWithRepititions(int arr[], int k) {

        List<List<Integer>> permutations = new ArrayList<List<Integer>>();

        if (arr != null && k > 0) {
            permutationsRepititionHelper(new ArrayList<Integer>(), arr, permutations, k);
        }

        return permutations;
    }

    private void permutationsRepititionHelper(List<Integer> permutation, int[] list, List<List<Integer>> permutations, int k) {

        if (permutation.size() == k) {

            List<Integer> perm = new ArrayList<Integer>(permutation);
            permutations.add(perm);

        } else {

            for (int i = 0; i < list.length; i++) {

                permutation.add(list[i]);
                permutationsRepititionHelper(permutation, list, permutations, k);
                permutation.remove(permutation.size() - 1);

            }

        }

    }


    public List<List<Integer>> permutationsWithRepititions2(int arr[], int k) {

        List<List<Integer>> permutations = new ArrayList<List<Integer>>();

        if (arr != null && arr.length != 0 && k > 0) {

            double number = Math.pow(arr.length, k);


            for (int i = 0; i < number; i++) {

                int num = i;
                List<Integer> permutation = new ArrayList<Integer>();

                for (int j = 0; j < k; j++) {
                    int index = num % arr.length;
                    permutation.add(arr[index]);
                    num = num / arr.length;
                }

                permutations.add(permutation);

            }
        }

        return permutations;
    }


}
