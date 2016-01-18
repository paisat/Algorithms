package arrays;

/**
 * Created by sarvothampai on 04/10/15.
 * <p/>
 * Time Complexity : O(Log N)
 */


public class MinimumElementInARotatedSortedArray {


    public static void main(String[] args) {

        MinimumElementInARotatedSortedArray obj = new MinimumElementInARotatedSortedArray();
        int nums[] = { 1, 2, 1 };
        System.out.println(obj.findMin(nums));

    }

    public int findMin(int[] nums) {


        int min = 0;

        if (nums != null && nums.length != 0) {
            return findPivot(0, nums.length - 1, nums);
        }

        return min;
    }

    public int findPivot(int low, int high, int arr[]) {

        if (high < low) {

            return arr[0];
        }

        if (high == low) {
            return arr[low];
        }


        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1]) {
            return arr[mid + 1];
        } else if (mid > low && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        } else if (arr[high] > arr[mid]) {
            return findPivot(low, mid - 1, arr);
        } else {
            return findPivot(mid + 1, high, arr);
        }


    }

}

