package arrays;

/**
 * Created by sarvothampai on 16/10/15.
 *
 *
 * Time Complexity : O(N)
 *
 * Contigious subarray
 *
 */
public class LargestSumContigiousSubArray {


    public static void main(String []args){

        LargestSumContigiousSubArray obj=new LargestSumContigiousSubArray();

        System.out.println(obj.maxSubArray(new int[]{-1,-2,-3}));

    }

    public int maxSubArray(int[] nums) {

        int curMax = nums[0], maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {

            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }

        return maxSoFar;

    }

}
