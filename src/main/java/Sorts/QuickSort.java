package Sorts;

/**
 * Created by sarvothampai on 25/10/15
 * <p/>
 * <p/>
 * Time Complexity : N log N
 * <p/>
 * Worst case Complexity : O(N^2) . When arrray is already sorted.
 */

public class QuickSort {


    public static void main(String[] args) {

        QuickSort obj = new QuickSort();

        int arr[] = { 10, 11, 12, 1 };

        obj.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    public void sort(int arr[]) {

        sortHelper(0, arr.length - 1, arr);

    }

    private void sortHelper(int low, int high, int arr[]) {
        if (low < high) {

            int p = partition(low, high, arr);
            sortHelper(low, p - 1, arr);
            sortHelper(p + 1, high, arr);
        }
    }

    private int partition(int low, int high, int arr[]) {

        int x = arr[high];
        int i = 0;

        for (int j = 0; j <= high; j++) {

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
