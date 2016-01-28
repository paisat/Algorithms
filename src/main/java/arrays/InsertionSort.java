package arrays;

/**
 * Created by sarvothampai on 25/10/15.
 * <p/>
 * complexity : O(N ^ 2)
 * <p/>
 * Best Time Complexity : O(N)
 *
 * Average is O(N^2)
 *
 *
 */
public class InsertionSort {


    public static void main(String[] args) {

        InsertionSort obj = new InsertionSort();

        int arr[] = { 6, 1, 2, 4 };

        obj.insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);

        }

    }


    public void insertionSort(int arr[]) {


        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

        }
    }

}
