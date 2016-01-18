package arrays;

/**
 * Created by sarvothampai on 04/10/15.
 * <p/>
 * In this we have to find higher pivot so we have to compare with low
 * <p/>
 * <p/>
 * Time Complexity : O(Log n)
 */


public class SearchInRotatedArray {

    public static void main(String[] args) {

        SearchInRotatedArray obj = new SearchInRotatedArray();

        int nums[] = { 3, 4, 5, 1, 2 };

        System.out.println(obj.search(nums, 1));

    }


    public int search(int[] nums, int target) {


        int result = -1;

        if (nums != null && nums.length != 0) {

            int pivot = findPivot(0, nums.length - 1, nums);

            if (pivot == -1) {
                return binarySearch(0, nums.length - 1, nums, target);
            }

            if (nums[pivot] == target) {
                return pivot;
            }

            if (nums[0] <= target) {

                return binarySearch(0, pivot - 1, nums, target);
            }

            return binarySearch(pivot + 1, nums.length - 1, nums, target);

        }

        return result;


    }


    public int binarySearch(int low, int high, int arr[], int target) {

        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearch(mid + 1, high, arr, target);
        }

        return binarySearch(low, mid - 1, arr, target);

    }


    public int findPivot(int low, int high, int arr[]) {

        if (low == high) {
            return low;
        }

        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }

        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        if (arr[low] < arr[mid]) {
            return findPivot(mid + 1, high, arr);
        }

        return findPivot(low, mid - 1, arr);

    }


}

