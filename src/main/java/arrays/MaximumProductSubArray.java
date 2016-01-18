package arrays;

/**
 * Created by sarvothampai on 17/10/15.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * <p/>
 * Works both for contigious and subset
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {

        MaximumProductSubArray obj = new MaximumProductSubArray();
        System.out.println(obj.maxProduct(new int[] { 2, 4, 5, -1, 4, 5, -2, 8 }));

    }

    public int maxProduct(int[] nums) {

        int minEndingHere = nums[0];
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {


            int temp = maxEndingHere;
            maxEndingHere = Math.max(Math.max(nums[i] * maxEndingHere, nums[i]), nums[i] * minEndingHere);
            minEndingHere = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minEndingHere);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);

        }

        return maxSoFar;


    }
}
