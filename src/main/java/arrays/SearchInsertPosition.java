package arrays;

/**
 * Created by sarvothampai on 20/10/15.
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

    public static void main(String []args){

        SearchInsertPosition obj =new SearchInsertPosition();

        int arr[]={1,3,5,6,8}; int target=7;

        System.out.println(obj.searchInsert(arr,target));
    }

    public int searchInsert(int[] nums, int target) {


        int low=0;
        int high=nums.length-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }

        return low;

    }
}
