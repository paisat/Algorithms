package arrays;

/**
 * Created by sarvothampai on 19/10/15.
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        if(nums!=null && nums.length!=0){
            int x=nums[0];

            for(int i=1;i<nums.length;i++){
                x=x^nums[i];
            }

            int y=0;
            for(int i=1;i<=nums.length;i++ ){
                y=y^i;
            }

            return x^y;

        }

        return -1;

    }
}
