package Sorts;

/**
 * Created by sarvothampai on 05/01/16.
 * <p/>
 * Time Complexity : O(N+k)
 * K is range
 * <p/>
 * Space Complexity : O(N+k)
 * <p/>
 * <p/>
 * Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted.
 * Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
 */

public class CountingSort {
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] arrayToSort = new int[] { 0, 3, 1, 0, 5, 2, 4, 5, 2 };
        int[] sortedArray = countingSort.counting_sort(arrayToSort);

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + ",");
        }
    }

    public int[] counting_sort(int[] arrayToSort) {
        int maxValue = getMaxVal(arrayToSort);
        int[] finalSortedArray = new int[arrayToSort.length];
        int[] tempArray = new int[maxValue + 1];

        for (int i = 0; i < arrayToSort.length; i++) {
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] + 1;
        }

        for (int i = 1; i < maxValue + 1; i++) {
            tempArray[i] = tempArray[i] + tempArray[i - 1];
        }

        for (int i = (arrayToSort.length - 1); i >= 0; i--) {
            finalSortedArray[tempArray[arrayToSort[i]] - 1] = arrayToSort[i];
            tempArray[arrayToSort[i]] = tempArray[arrayToSort[i]] - 1;
        }
        return finalSortedArray;
    }

    private int getMaxVal(int[] arrayToSort) {
        int maxVal = Integer.MIN_VALUE;
        for (int i : arrayToSort) {
            if (i > maxVal) {
                maxVal = i;
            }
        }
        return maxVal;
    }
}
