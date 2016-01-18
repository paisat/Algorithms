package arrays;

/**
 * Created by sarvothampai on 15/10/15.
 *
 *
 * Time Complexity : O(N)
 */
public class SearchInRotatedSortedArrayWithDuplicates {

    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;


        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[low] < nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }


            } else if (nums[low] > nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                low++;
            }


        }


        return false;


    }
}
