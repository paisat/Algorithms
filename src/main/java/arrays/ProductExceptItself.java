package arrays;

/**
 * Created by sarvothampai on 17/10/15.
 *
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 For example, given [1,2,3,4], return [24,12,8,6].
 Follow up:
 Could you solve it with constant space complexity?
 (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


 Time Complexity : O(N)


 */


public class ProductExceptItself {

    public int[] productExceptSelf(int[] nums) {


        int product[] =new int[nums.length];

        int temp=1;

        for(int i=0;i<nums.length;i++){
            product[i]=temp;
            temp=temp*nums[i];
        }

        temp=1;

        for(int i=nums.length-1;i>=0;i--){

            product[i] *=temp;
            temp=temp*nums[i];
        }

        return product;

    }
}
