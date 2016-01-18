package arrays;

/**
 * Created by sarvothampai on 19/10/15.
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Time Complexity : O(N)

 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums != null && nums.length != 0) {


            int prev = -1;
            int i = 0;

            while (i < nums.length) {

                if (nums[i] == val) {

                    i++;
                } else {
                    prev++;
                    nums[prev] = nums[i];
                    i++;
                }

            }

            return prev + 1;

        }

        return 0;

    }
}
