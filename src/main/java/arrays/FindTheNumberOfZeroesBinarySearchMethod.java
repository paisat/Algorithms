package arrays;

/**
 * Created by sarvothampai on 29/11/15.
 * <p/>
 * Time Complexity : O(log n)
 */

//todo coplete this
public class FindTheNumberOfZeroesBinarySearchMethod {

    public static void main(String[] args) {

        FindTheNumberOfZeroesBinarySearchMethod obj = new FindTheNumberOfZeroesBinarySearchMethod();
        int arr[] = { 1, 1, 1, 1, 0 };

        System.out.println(obj.findFirstZeroIndex(arr));

    }

    public Integer findFirstZeroIndex(int arr[]) {


        if (arr != null && arr.length != 0) {

            int index = firstZeroIndexHelper(arr, 0, arr.length - 1);

            if (index == -1) {
                return null;
            }

            return arr.length - 1 - index + 1;
        }

        return null;


    }


    private int firstZeroIndexHelper(int arr[], int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == 0 && (mid == 0 || arr[mid - 1] != 0)) {
            return mid;
        }

        if (arr[mid] == 1) {
            return firstZeroIndexHelper(arr, mid + 1, high);
        }

        return firstZeroIndexHelper(arr, low, mid - 1);
    }

}
