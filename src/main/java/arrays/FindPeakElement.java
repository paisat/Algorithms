package arrays;

/**
 * Created by sarvothampai on 16/10/15.
 *
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 *
 * Wont give MAX peak.
 *
 * Time Complexity O(Log n)
 *
 */
public class FindPeakElement {

    public static void main(String[] args) {

        FindPeakElement obj = new FindPeakElement();

        int nums[] = { 1, 2 };

        System.out.println(obj.findPeakElement(nums));


    }

    public int findPeakElement(int[] nums) {


        if (nums != null && nums.length != 0) {


            if (nums.length == 1) {
                return 0;
            }

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {

                int mid = (low) + (high - low) / 2;

                if (( mid==0 || mid > 0 && nums[mid] >= nums[mid - 1])
                        && ( mid==nums.length-1 || mid < nums.length - 1 && nums[mid] >= nums[mid + 1])) {
                    return mid;
                }

                if (mid > 0 && nums[mid] < nums[mid - 1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }

        }

        return 0;


    }
}
