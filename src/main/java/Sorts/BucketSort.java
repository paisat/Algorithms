package Sorts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 05/01/16.
 * <p/>
 * <p/>
 * Best Time Complexity : O(N+k)
 *
 * K is the range of input
 *
 * <p/>
 * Worst case TIme Complexity : O(N^2)
 * <p/>
 * Used when input is under a range.
 * <p/>
 * Sort an infinite character stream.
 */
public class BucketSort {

    void bucketSort(float arr[], int n) {
        // 1) Create n empty buckets
        List<Float> buckets[] = new List[n];

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int index = (int) (n * arr[i]); // Index in bucket
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<Float>();
                buckets[index].add(arr[i]);
            } else {
                buckets[index].add(arr[i]);
            }
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]);
            }
        }


        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; buckets[i] != null && j < buckets[i].size(); j++)
                arr[index++] = buckets[i].get(j);
    }
}
