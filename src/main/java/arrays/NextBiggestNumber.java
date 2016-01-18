package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 20/10/15.
 *
 * <p/>
 * <p/>
 * Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.
 * <p/>
 * Examples:
 * For simplicity of implementation, we have considered input number as a string.
 * <p/>
 * Input:  n = "218765"
 * Output: "251678"
 * <p/>
 * Input:  n = "1234"
 * Output: "1243"
 * <p/>
 * Input: n = "4321"
 * Output: "Not Possible"
 * <p/>
 * Input: n = "534976"
 * Output: "536479"
 * <p/>
 *
 *
 * Time Complexity : O(N)
 */
public class NextBiggestNumber {


    public void nextPermutation(int[] nums) {

        if (nums != null && nums.length != 0) {


            if (nums.length == 1) {
                return;
            }

            boolean isSortedDESC = true;
            boolean isSortedAesc = true;

            int i = 0;

            while (i < nums.length - 1) {

                if (nums[i + 1] > nums[i] && isSortedDESC) {
                    isSortedDESC = false;
                }

                if (nums[i + 1] < nums[i] && isSortedAesc) {
                    isSortedAesc = false;
                }

                i++;

            }

            if (isSortedDESC) {
                Arrays.sort(nums);
                return;
            }

            if (isSortedAesc) {
                int temp = nums[nums.length - 1];
                nums[nums.length - 1] = nums[nums.length - 2];
                nums[nums.length - 2] = temp;
                return;
            }


            i = nums.length - 1;

            while (i >= 1 && nums[i - 1] >= nums[i]) {
                i--;
            }

            int index = getNextBiggestNumber(nums, i, nums.length - 1, nums[--i]);

            System.out.print(index);

            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            Arrays.sort(nums, i + 1, nums.length);


        }

    }

    private int getNextBiggestNumber(int nums[], int low, int high, int target) {


        while (low <= high) {

            if (target < nums[high]) {
                return high;

            }

            if (target > nums[low]) {
                return -1;
            }

            int mid = low + (high - low) / 2;

            if (nums[mid] > target && mid < high && !(nums[mid + 1] > target)) {
                return mid;
            }

            if (nums[mid] <= target) {

                if (mid > low && nums[mid - 1] > target) {
                    return mid - 1;
                } else {

                    high = mid - 1;

                }

            } else {

                if (mid < high && nums[mid + 1] < target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }

        }

        return -1;
    }
}
