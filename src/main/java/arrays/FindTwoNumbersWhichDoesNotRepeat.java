package arrays;

/**
 * Created by sarvothampai on 20/10/15.
 * <p/>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p/>
 * For example:
 * <p/>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p/>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */


//// TODO: 26/10/15 Print two repeating numbers code
public class FindTwoNumbersWhichDoesNotRepeat {

    public int[] singleNumber(int[] nums) {


        int[] result = new int[2];

        if (nums != null && nums.length != 0) {

            int x = nums[0];

            for (int i = 1; i < nums.length; i++) {
                x = x ^ nums[i];
            }

            int y = (x & -x);

            int a = 0, b = 0;

            for (int i = 0; i < nums.length; i++) {

                if ((y & nums[i]) != 0) {

                    a = a ^ nums[i];

                } else {
                    b = b ^ nums[i];
                }

            }

            result[0] = a;
            result[1] = b;


        }

        return result;

    }


}
