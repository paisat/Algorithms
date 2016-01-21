package arrays;

/**
 * Created by sarvothampai on 18/01/16.
 * <p/>
 * <p/>
 * Time complexity : Average : O(N)
 * Worst Case complexity : O(N^2)
 *
 *
 * Heap
 *
 * Complexity :
 *
 * We can also use Max Heap for finding the k’th smallest element. Following is algorithm.
 1) Build a Max-Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)

 2) For each element, after the k’th element (arr[k] to arr[n-1]), compare it with root of MH.
 ……a) If the element is less than the root then make it root and call heapify for MH
 ……b) Else ignore it.
 // The step 2 is O((n-k)*logk)

 3) Finally, root of the MH is the kth smallest element.
 *
 * Time complexity of this solution is O(k + (n-k)*Logk)
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
