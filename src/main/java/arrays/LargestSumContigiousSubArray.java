package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        //System.out.println(obj.maxSubArray(new int[] { -1, -2, -3 }));

        List<Integer> input=new ArrayList<Integer>();
        input.add(-2);
        input.add(-5);
        input.add(-1);
        input.add(456);
        input.add(-3);

        System.out.println(obj.maxSubArray(input));

    }

    public List<Integer> maxSubArray(List<Integer> nums) {

        List<Integer> result=new ArrayList<Integer>();

        if(nums!=null && nums.size()!=0) {

            int curMax = nums.get(0), maxSoFar = nums.get(0);
            int start = 0, end = 0;
            int tempStart = 0, tempEnd = 0;


            for (int i = 1; i < nums.size(); i++) {

                if (curMax + nums.get(i) > nums.get(i)) {
                    curMax = curMax + nums.get(i);
                    tempEnd = i;
                } else {
                    curMax = nums.get(i);
                    tempStart = i;
                    tempEnd = i;
                }

                if (curMax > maxSoFar) {
                    start = tempStart;
                    end = tempEnd;
                }

                maxSoFar = Math.max(maxSoFar, curMax);
            }

            result.addAll(nums.subList(start,end+1));

        }

        return result;

    }


    /**
     * Complexity :  n(Log n)
     * <p/>
     * T(n) = 2T(N/2) + O(N)
     */
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
