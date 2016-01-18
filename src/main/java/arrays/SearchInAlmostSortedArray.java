package arrays;

/**
 * Created by sarvothampai on 26/10/15.
 *
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

 For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

 Example:
 *
 */
public class SearchInAlmostSortedArray {


    public static void main(String[] args) {

        SearchInAlmostSortedArray obj = new SearchInAlmostSortedArray();

        int nums[] = { 10, 3, 40, 20, 50, 80, 70 };
        int nums1[] = { 10, 3, 40, 20, 50, 80, 70 };

        System.out.println(obj.binarySearch(nums, 0, nums.length - 1, 40));
        System.out.println(obj.binarySearch(nums, 0, nums1.length - 1, 90));

    }


    public int binarySearch(int nums[], int low, int high, int x) {

        if (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == x) {
                return mid;
            }

            if (mid > low && nums[mid - 1] == x) {
                return mid - 1;
            }

            if (mid < high && nums[mid + 1] == x) {
                return mid + 1;
            }

            if (nums[mid] < x) {
                return binarySearch(nums, mid + 2, high, x);
            }

            return binarySearch(nums, low, mid - 2, x);

        }

        return -1;

    }
}
