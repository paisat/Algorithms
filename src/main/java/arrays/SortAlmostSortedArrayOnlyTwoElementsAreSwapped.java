package arrays;

/**
 * Created by sarvothampai on 26/10/15.
 * <p/>
 * Sort an almost sorted array where only two elements are swapped
 * Given an almost sorted array where only two elements are swapped, how to sort the array efficiently?
 * <p/>
 * Example
 * <p/>
 * Input:  arr[] = {10, 20, 60, 40, 50, 30}
 * // 30 and 60 are swapped
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 * <p/>
 * Input:  arr[] = {10, 20, 40, 30, 50, 60}
 * // 30 and 40 are swapped
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 * <p/>
 * Input:   arr[] = {1, 5, 3}
 * // 3 and 5 are swapped
 * Output:  arr[] = {1, 3, 5}
 * <p/>
 * Time Complexity : O(N)
 */
public class SortAlmostSortedArrayOnlyTwoElementsAreSwapped {


    void sortByOneSwap(int arr[], int n) {
        // Travers the given array from rightmost side
        for (int i = n - 1; i > 0; i--) {
            // Check if arr[i] is not in order
            if (arr[i] < arr[i - 1]) {
                // Find the other element to be
                // swapped with arr[i]
                int j = i - 1;
                while (j >= 0 && arr[i] < arr[j])
                    j--;

                // Swap the pair

                break;
            }
        }

    }
}
