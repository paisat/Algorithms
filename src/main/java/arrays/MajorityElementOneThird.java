package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 04/10/15.
 *  Dont add duplicate elements in result set;
 *  When list has only 2 elements add all . Dont add duplicate elements.
 *
 */


public class MajorityElementOneThird {


    public static void main(String args[]){

        MajorityElementOneThird obj=new MajorityElementOneThird();
        System.out.println(obj.majorityElement(new int[]{1}));


    }

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<Integer>();



        if(nums!=null && nums.length!=0){


            int count1=0;
            int count2=0;

            int a=0,b=0;

            for(int i=0;i<nums.length;i++){

                if( count1==0 || nums[i]==a){
                    a=nums[i];
                    count1++;
                }

                else if( count2==0|| nums[i]==b){
                    b=nums[i];
                    count2++;
                }
                else {
                    count1--;
                    count2--;
                }

            }


            int counta=0,countb=0;

            for(int num : nums){

                if(num==a){
                    counta++;
                }

                if(num==b){
                    countb++;
                }
            }

            if(counta>nums.length/3){
                result.add(a);
            }

            if(countb>nums.length/3 && !result.contains(b) ){
                result.add(b);
            }


        }


        return result;
    }

}
