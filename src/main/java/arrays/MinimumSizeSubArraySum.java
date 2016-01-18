package arrays;

/**
 * Created by sarvothampai on 13/11/15.
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the problem constraint.
 *
 * time complexity : O(n)
 */
public class MinimumSizeSubArraySum {


    public static void main(String []args){

        MinimumSizeSubArraySum obj  =new MinimumSizeSubArraySum();
        System.out.println(obj.minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }


    public int minSubArrayLen(int s, int[] nums) {

        int result=0;

        if(nums!=null && nums.length!=0){


            int start=0,end=0; int min=Integer.MAX_VALUE;
            int sum=0;

            while(end<nums.length){

                while(end<nums.length && sum<s){
                    sum+=nums[end];
                    end++;
                }

                if(sum<s){
                    break;
                }

                while(start<end  && sum>=s){

                    sum-=nums[start];
                    start++;
                    min=Math.min(min,end-start+1);
                }

            }

            result=(min==Integer.MAX_VALUE)?0:min;

        }

        return result;

    }

}
