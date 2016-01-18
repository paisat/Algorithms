package arrays;

/**
 * Created by sarvothampai on 20/10/15.
 * <p/>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p/>
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * Time complexity : O(n Log n);
 *
 *
 */
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate obj = new FindDuplicate();

        int nums[] = { 1,3,3,2,4,5 };

        System.out.println(obj.findDuplicate(nums));

    }

    public int findDuplicate(int[] nums) {

        if (nums != null && nums.length != 0) {


            int low = 0;
            int high = nums.length - 1;

            while (low < high) {

                int mid = low + (high - low) / 2;

                int count = getCount(nums, mid);

                if (count <= mid) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;

        }

        return -1;

    }

    private int getCount(int nums[], int mid) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= mid) {
                count++;
            }

        }

        return count;
    }
}
