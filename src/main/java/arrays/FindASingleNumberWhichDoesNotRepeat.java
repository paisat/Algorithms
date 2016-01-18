package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 07/10/15.
 * <p/>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p/>
 * Time Complexity : O(n)
 */
public class FindASingleNumberWhichDoesNotRepeat {


    public static void main(String []args){

        FindASingleNumberWhichDoesNotRepeat obj =new FindASingleNumberWhichDoesNotRepeat();

        int nums[]={1,1,3,4,4};

        System.out.println(obj.singleNumberBinarySearchMethod(nums));

    }

    public int singleNumber(int[] nums) {

        if (nums != null && nums.length != 0) {

            int x = nums[0];

            for (int i = 1; i < nums.length; i++) {
                x = x ^ nums[i];
            }

            return x;
        }

        return 0;
    }


    public Integer singleNumberBinarySearchMethod(int[] nums) {

        if (nums != null && nums.length != 0) {
            Arrays.sort(nums);
            return findNumberWhichDoesNotRepeatHelper(nums, 0, nums.length - 1);
        }

        return null;
    }

    private Integer findNumberWhichDoesNotRepeatHelper(int nums[], int low, int high) {

        if (low > high) {
            return null;
        }

        if (low == high) {
            return nums[low];
        }

        int mid = (low + high) / 2;


        if (mid % 2 == 0) {
            if (nums[mid] == nums[mid + 1]) {
                return findNumberWhichDoesNotRepeatHelper(nums, mid + 2, high);
            } else {
                return findNumberWhichDoesNotRepeatHelper(nums, low, mid);
            }
        } else {

            if (nums[mid] == nums[mid -1]) {
                return findNumberWhichDoesNotRepeatHelper(nums, mid+1,high);
            } else {
                return findNumberWhichDoesNotRepeatHelper(nums, low, mid-1);
            }

        }

    }
}
