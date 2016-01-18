package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 04/10/15.
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k.
 *
 * Time Complexity : O(N)
 *
 */


public class ContainsNearByDuplicate{


    public static void main(String []args){

        ContainsNearByDuplicate obj =new ContainsNearByDuplicate();

        int arr[]={1, 2, 3, 4, 1, 2, 3, 4}; int k1=3;

         int  k2 = 3, arr2[] = {1, 2, 3, 1, 4, 5};

        int k3 = 1, arr3[] = {1,0,1,1};


        System.out.println(obj.containsNearbyDuplicate(arr,k1));
        System.out.println(obj.containsNearbyDuplicate(arr2,k2));
        System.out.println(obj.containsNearbyDuplicate(arr3,k3));


    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums!=null && nums.length!=0 ){

            Map<Integer,Integer> hash =new HashMap<Integer,Integer>();

            for(int i=0;i<nums.length;i++){

                if(hash.get(nums[i])==null){
                    hash.put(nums[i],i);
                }
                else{

                    if(i-hash.get(nums[i])<=k){

                        return true;
                    }
                    else {
                        hash.put(nums[i],i);
                    }
                }
            }

            return false;

        }

        return false;

    }


}

