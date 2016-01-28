package Sorts;

/**
 * Created by sarvothampai on 05/01/16.
 *
 *
 * Worst case : O(N^2)
 * Best case : O(N).  When array is already sorted;
 * Average Case : O(N^2)
 *
 *
 */
public class BubbleSort {

    public void bubbleSort(int arr[], int n) {
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
}
