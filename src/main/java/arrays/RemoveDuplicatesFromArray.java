package arrays;

/**
 * Created by sarvothampai on 19/10/15.
 *
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 For example,
 Given input array nums = [1,1,2],
 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 Time Complexity : O(N)

 */
public class RemoveDuplicatesFromArray {

    public int removeDuplicates(int[] nums) {

        if(nums!=null && nums.length!=0){


            int length=nums.length;

            int j=0;
            int i=1;

            while(i<length){

                if(nums[i]==nums[j]){
                    i++;
                    continue;
                }
                else{

                    j++;
                    nums[j]=nums[i];
                    i++;

                }
            }

            return j+1;

        }

        return 0;

    }
}
