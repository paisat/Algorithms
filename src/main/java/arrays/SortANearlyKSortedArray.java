package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by sarvothampai on 26/10/15.
 *
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time.
 For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 */
public class SortANearlyKSortedArray {


    public static void main(String[] args) {

        SortANearlyKSortedArray obj = new SortANearlyKSortedArray();

        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int k = 3;

        obj.sort(arr, k);

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }


    }


    public void sort(int arr[], int k) {

        if (arr == null || arr.length == 0 || k < 0) {
            return;
        }


        Queue<Integer> queue = new PriorityQueue<Integer>(10, new Comparator<Integer>() {


            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });


        for (int i = 0; i <= k && i < arr.length; i++) {

            queue.add(arr[i]);


        }


        int j = 0;
        int i = k + 1;

        while (j < arr.length) {

            if (i < arr.length) {
                queue.add(arr[i]);

            } else {

                arr[j] = queue.poll();
                j++;
            }

            i++;

        }


    }

}
