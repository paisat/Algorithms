package arrays;

/**
 * Created by sarvothampai on 04/10/15.
 * <p/>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p/>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p/>
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */


public class SearchRange {


    public static void main(String[] args) {


        SearchRange obj = new SearchRange();
//
//        int nums[]={1};
//
//        int result[]=obj.searchRange(nums,1);
//
//        for(int i : result){
//            System.out.print(i+" ");
//        }

        int[] res = obj.searchRange2(new int[] { 1 }, 0);

        System.out.println(res[0]);
        System.out.println(res[1]);


    }

    public int[] searchRange(int[] nums, int target) {

        if (nums != null && nums.length != 0) {

            return binarySearch(0, nums.length - 1, target, nums);
        }

        int result[] = { -1, -1 };

        return result;
    }


    private int[] binarySearch(int low, int high, int target, int[] nums) {

        if (high < low) {

            int result[] = { -1, -1 };
            return result;
        }


        int mid = (low + high) / 2;

        if (nums[mid] == target) {

            int result[] = new int[2];

            int leftIndex = mid;
            while (leftIndex > 0 && nums[leftIndex - 1] == nums[mid]) {
                leftIndex--;
            }

            int rightIndex = mid;

            while (rightIndex < high && nums[rightIndex + 1] == nums[mid]) {
                rightIndex++;
            }

            result[0] = leftIndex;
            result[1] = rightIndex;

            return result;


        } else if (target < nums[mid]) {
            return binarySearch(low, mid - 1, target, nums);
        }

        return binarySearch(mid + 1, high, target, nums);

    }

    public int[] searchRange2(int[] A, int target) {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }


}

