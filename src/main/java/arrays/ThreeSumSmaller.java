package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 12/11/15.
 * <p/>
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p/>
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * <p/>
 * Return 2. Because there are two triplets which sums are less than 2:
 * <p/>
 * [-2, 0, 1]
 * [-2, 0, 3]
 * <p/>
 * Time Complexity : O(n log
 * n)
 */
public class ThreeSumSmaller {


    public static void main(String[] args) {

        ThreeSumSmaller obj = new ThreeSumSmaller();
        System.out.println(obj.ThreeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
    }


    public int ThreeSumSmaller(int[] nums, int target) {


        int result = 0;


        if (nums != null && nums.length != 0) {


            Arrays.sort(nums);


            for (int i = 0; i < nums.length - 2; i++) {


                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {

                    int sum = nums[i] + nums[l] + nums[r];

                    if (sum < target) {
                        l++;
                        result += (r - l) + 1;
                    } else {
                        r--;
                    }

                }

            }


        }


        return result;

    }
}
