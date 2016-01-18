package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sarvothampai on 11/12/15.
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {



        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums!=null && nums.length!=0){

            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums){
                list.add(i);
            }

            permutationHelper(list,new ArrayList(),result);

        }

        return result;

    }

    public void permutationHelper(List<Integer> nums,List<Integer> permutation , List<List<Integer>> result){

        if(nums.size()==0){
            result.add(permutation);
        }
        else{

            for(int i=0;i<nums.size();i++){

                List<Integer> perm=new ArrayList<Integer>();
                List<Integer> restNums =new ArrayList<Integer>();


                perm.add(nums.get(i));
                restNums.addAll(nums.subList(0,i));
                restNums.addAll(nums.subList(i+1,restNums.size()));

                permutationHelper(restNums,perm,result);


            }

        }

    }
}
