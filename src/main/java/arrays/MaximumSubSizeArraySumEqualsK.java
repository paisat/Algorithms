package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 06/03/16.
 * <p/>
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * Follow Up:
 * Can you do it in O(n) time?
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class MaximumSubSizeArraySumEqualsK {

    public static void main(String[] args) {

        MaximumSubSizeArraySumEqualsK obj = new MaximumSubSizeArraySumEqualsK();

        int arr[] = { -2, -1, 2, 1 };
        int k = 1;

        System.out.println(obj.maxSubArrayLen(arr, k));
        System.out.println(obj.maxSubArrayLen(new int[] { 1, -1, 5, -2, 3 }, 3));

    }


    public int maxSubArrayLen(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        hashMap.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }

            if (hashMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - hashMap.get(sum - k));
            }


        }

        return maxLen;


    }


}
