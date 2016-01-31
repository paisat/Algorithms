package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sarvothampai on 18/01/16.
 * <p/>
 * <p/>
 * Time complexity : Average : O(N)\
 * <p>
 * <p>
 * <p>
 * Worst Case complexity : O(N^2)
 * <p>
 * When Does worst case happens ?
 * When you choose minimum element as an pivot. You will be pealing off single element from an array and it leads to O(N^2) time.
 * <p>
 * During randomized select algorithm choosing a minimum element as an medium is very less probabale
 * <p>
 * What is the best pivot ?
 * <p>
 * Best pivot is the median.
 * <p>
 * Average complexity is O(N) . If the randomizded select algorithm chooses something close to a median . Then we have to recurse only one side
 * So the average time complexity of this algorithm is O(N)
 * <p>
 * <p>
 * <p>
 * Heap
 * <p>
 * Complexity :
 * <p>
 * We can also use Max Heap for finding the k’th smallest element. Following is algorithm.
 * 1) Build a Max-Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)
 * <p>
 * 2) For each element, after the k’th element (arr[k] to arr[n-1]), compare it with root of MH.
 * ……a) If the element is less than the root then make it root and call heapify for MH
 * ……b) Else ignore it.
 * // The step 2 is O((n-k)*logk)
 * <p>
 * 3) Finally, root of the MH is the kth smallest element.
 * <p>
 * Time complexity of this solution is O(k + (n-k)*Log k)
 */
public class Kthsmallest {


    public static void main(String []args){

        Kthsmallest obj=new Kthsmallest();
        System.out.println(obj.kthsmallestHeapMethod(new int[]{56,12,11,45,3},3));

    }

    /**
     * Average Complexity : O(N)
     * <p>
     * WorstCase Complexity : O(N^2)
     * <p>
     * When Does worst case happens ?
     * When you choose minimum element as an pivot. You will be pealing off single element from an array and it leads to O(N^2) time.
     * <p>
     * During randomized select algorithm choosing a minimum element as an medium is very less probabale
     * <p>
     * What is the best pivot ?
     * <p>
     * Best pivot is the median.
     * <p>
     * Average complexity is O(N) . If the randomizded select algorithm chooses something close to a median . Then we have to recurse only one side
     * So the average time complexity of this algorithm is O(N)
     */
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



    /**
     *
     * Time Complexity : O(K) to construct the heap.
     *
     * O(K) + O(n-k * Log k)
     *
     *
     *
     * */
    public Integer kthsmallestHeapMethod(int arr[], int k) {


        if (arr != null && arr.length != 0 && k > 0 && k <= arr.length) {


            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });


            int i = 0;


            for (i = 0; i < arr.length && i < k; i++) {
                maxHeap.add(arr[i]);
            }

            for (; i < arr.length; i++) {

                if (arr[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }

            }
            return maxHeap.peek();

        }
        return null;
    }

    /**
     *
     *
     * Worst case time complexity : O(N)
     *
     *
     * */

//    int findMedian(int arr[], int n)
//    {
//        sort(arr, arr+n);  // Sort the array
//        return arr[n/2];   // Return middle element
//    }
//
//    // Returns k'th smallest element in arr[l..r] in worst case
//// linear time. ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
//    int kthSmallestLinear(int arr[], int l, int r, int k)
//    {
//        // If k is smaller than number of elements in array
//        if (k > 0 && k <= r - l + 1)
//        {
//            int n = r-l+1; // Number of elements in arr[l..r]
//
//            // Divide arr[] in groups of size 5, calculate median
//            // of every group and store it in median[] array.
//            int i;
//            int median[] =new int[(n+4)/5];// There will be floor((n+4)/5) groups;
//            for (i=0; i<n/5; i++)
//                median[i] = findMedian(arr+l+i*5, 5);
//            if (i*5 < n) //For last group with less than 5 elements
//            {
//                median[i] = findMedian(arr+l+i*5, n%5);
//                i++;
//            }
//
//            // Find median of all medians using recursive call.
//            // If median[] has only one element, then no need
//            // of recursive call
//            int medOfMed = (i == 1)? median[i-1]:
//                    kthSmallest(median, 0, i-1, i/2);
//
//            // Partition the array around a random element and
//            // get position of pivot element in sorted array
//            int pos = partition(arr, l, r, medOfMed);
//
//            // If position is same as k
//            if (pos-l == k-1)
//                return arr[pos];
//            if (pos-l > k-1)  // If position is more, recur for left
//                return kthSmallestLinear(arr, l, pos-1, k);
//
//            // Else recur for right subarray
//            return kthSmallestLinear(arr, pos+1, r, k-pos+l-1);
//        }
//
//        // If k is more than number of elements in array
//        return INT_MAX;
//    }
//
//    void swap(int *a, int *b)
//    {
//        int temp = *a;
//        *a = *b;
//        *b = temp;
//    }
//
//    // It searches for x in arr[l..r], and partitions the array
//// around x.
//    int partition(int arr[], int l, int r, int x)
//    {
//        // Search for x in arr[l..r] and move it to end
//        int i;
//        for (i=l; i<r; i++)
//            if (arr[i] == x)
//                break;
//        swap(&arr[i], &arr[r]);
//
//        // Standard partition algorithm
//        i = l;
//        for (int j = l; j <= r - 1; j++)
//        {
//            if (arr[j] <= x)
//            {
//                swap(&arr[i], &arr[j]);
//                i++;
//            }
//        }
//        swap(&arr[i], &arr[r]);
//        return i;
//    }




}
