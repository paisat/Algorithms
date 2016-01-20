package arrays;

/**
 * Created by sarvothampai on 16/10/15.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * <p/>
 * Contigious subarray
 */
public class LargestSumContigiousSubArray {


    public static void main(String[] args) {

        LargestSumContigiousSubArray obj = new LargestSumContigiousSubArray();

        System.out.println(obj.maxSubArray(new int[] { -1, -2, -3 }));

    }

    public int maxSubArray(int[] nums) {

        int curMax = nums[0], maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {

            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }

        return maxSoFar;

    }


    /**
     *
     *
     *  Complexity :  n(Log n)
     *
     *
     * */
    int maxCrossingSum(int arr[], int l, int m, int h) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left and right of mid
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray in aa[l..h]
    int maxSubArraySum(int arr[], int l, int h) {
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h) / 2;

   /* Return maximum of following three possible cases
      a) Maximum subarray sum in left half
      b) Maximum subarray sum in right half
      c) Maximum subarray sum such that the subarray crosses the midpoint */
        return Math.max(maxSubArraySum(arr, l, m),
                Math.max(maxSubArraySum(arr, m + 1, h),
                        maxCrossingSum(arr, l, m, h)));
    }

}
