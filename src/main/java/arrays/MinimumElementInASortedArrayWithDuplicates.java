package arrays;

/**
 * Created by sarvothampai on 04/10/15.
 *
 * Time Complexity : O(N)
 *
 */
public class MinimumElementInASortedArrayWithDuplicates {


    public static void main(String []args){

        MinimumElementInASortedArrayWithDuplicates obj=new MinimumElementInASortedArrayWithDuplicates();

        int nums[]={1,2,1};

        System.out.println(obj.findMin(nums));

    }

    public int findMin(int[] nums) {


        if(nums !=null && nums.length!=0){

            return findMinRec(0,nums.length-1,nums);
        }

        return 0;

    }


    public int findMinRec(int low , int high , int []nums){


        if(high<low){
            return nums[0];
        }

        if(high==low){
            return nums[high];
        }

        int mid = (low+high)/2;

        if(mid>low && nums[mid] < nums[mid-1]){
            return nums[mid];
        }

        if(mid<high && nums[mid]>nums[mid+1] ){
            return nums[mid+1];
        }

        if(nums[mid]==nums[high] && nums[low]==nums[mid]){
            return Math.min(findMinRec(low,mid-1,nums),findMinRec(mid+1,high,nums));
        }

        if(nums[mid]<=nums[high]){ // equality required for inputs {1,3,3}
            return findMinRec(low,mid-1,nums);
        }

        return findMinRec(mid+1,high,nums);

    }

}
