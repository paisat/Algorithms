package arrays;

/**
 * Created by sarvothampai on 18/01/16.
 *
 *
 * Time complexity : Average : O(N)
 * Worst Case complexity : O(N^2)
 *
 */
public class Kthsmallest {

    int kthSmallest(int arr[], int l, int r, int k) {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last element and get
            // position of pivot element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)  // If position is more, recur for left subarray
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements in array
        return Integer.MAX_VALUE;
    }


    // Standard partition process of QuickSort().  It considers the last
// element as pivot and moves all smaller element to left of it
// and greater elements to right
    int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r; j++) {
            if (arr[j] <= x) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        return i - 1;
    }
}
