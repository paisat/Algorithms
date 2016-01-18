package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sarvothampai on 12/11/15.
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


 Time Complexity : O(n^2)
 *
 */
public class ThreeSumClosest {

    public static void main(String []args){

        ThreeSumClosest obj =new ThreeSumClosest();

        System.out.println(obj.threeSumClosest(new int[]{4,-1,-4,4},-1));

    }

    public int threeSumClosest(int[] nums, int target) {


        int result=0;


        if(nums!=null && nums.length!=0){

            int min =Integer.MAX_VALUE;

            Arrays.sort(nums);


            for(int i=0;i<nums.length-2;i++){


                int l=i+1;
                int r=nums.length-1;

                while (l<r){

                    int sum=nums[i]+nums[l]+nums[r];

                    int diff = Math.abs(sum-target);

                    if(diff==0){
                        return sum;

                    }

                    if(diff<min){
                        min=diff;
                        result=sum;
                    }

                    if(sum<target){
                        l++;
                    }
                    else{
                        r--;
                    }

                }

            }


        }

        return result;

    }

}
