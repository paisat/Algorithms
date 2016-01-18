package arrays;

/**
 * Created by sarvothampai on 19/10/15.
 *
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.

 Time Complexity : O(N)

 *
 */
public class RemoveDuplicatesFromSortedArray2 {



    public static void main(String []args){

        RemoveDuplicatesFromSortedArray2 obj=new RemoveDuplicatesFromSortedArray2();

        int nums[]={1,1,1,1,3,3};

        int len=obj.removeDuplicates(nums);

        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }

    }


    public int removeDuplicates(int[] nums) {

        if(nums!=null && nums.length!=0){

            if(nums.length==2){
                return 2 ;
            }


            int prev=1;
            int cur=2;

            while(cur<nums.length){

                if(nums[cur]==nums[prev] && nums[cur]==nums[prev-1] ){
                    cur++;
                }
                else{
                    prev++;
                    nums[prev]=nums[cur];
                    cur++;
                }
            }

            return prev+1;

        }

        return 0;

    }
}
