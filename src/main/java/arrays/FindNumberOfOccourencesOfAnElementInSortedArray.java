package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 28/01/16.
 * <p>
 * <p>
 * Time Complexity : O( log N )
 */
public class FindNumberOfOccourencesOfAnElementInSortedArray {

    public static void main(String[] args) {

        int arr[] = { 2, 2, 2, 21, 1, 3, 3 };

        FindNumberOfOccourencesOfAnElementInSortedArray obj = new FindNumberOfOccourencesOfAnElementInSortedArray();

        System.out.println(obj.findNumberOfOccurences(arr, 3));

    }


    public int findNumberOfOccurences(int arr[], int x) {

        if (arr != null && arr.length != 0) {

            Arrays.sort(arr);


            int index = firstPosition(arr, x, 0);

            if (index == arr.length || arr[index] != x) {
                return 0;
            }

            int nextIndex = firstPosition(arr, x + 1, index + 1) - 1;

            return nextIndex - index + 1;

        }

        return 0;

    }

    private int firstPosition(int arr[], int x, int searchFrom) {

        int low = searchFrom;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low;

    }
}
