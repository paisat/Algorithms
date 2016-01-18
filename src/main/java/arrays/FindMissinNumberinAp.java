package arrays;

/**
 * Created by sarvothampai on 29/11/15.
 */

//todo complete this
public class FindMissinNumberinAp {

    public static void main(String[] args) {

        FindMissinNumberinAp obj = new FindMissinNumberinAp();

        int arr[] = { 2, 4, 8, 10, 12, 14 };
        int arr1[] = { 1, 6, 11, 16, 21, 31 };

        System.out.println(obj.findMissingElementInAp(arr));
        System.out.println(obj.findMissingElementInAp(arr1));
    }

    public Integer findMissingElementInAp(int arr[]) {

        if (arr != null && arr.length != 0) {
            int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
            return findMissingAPHelper(arr, 0, arr.length - 1, diff);
        }
        return null;

    }

    private Integer findMissingAPHelper(int arr[], int low, int high, int diff) {

        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        if (mid < high && arr[mid + 1] - arr[mid] != diff) {
            return arr[mid] + diff;
        }

        if (mid > low && arr[mid] - arr[mid - 1] != diff) {
            return arr[mid - 1] + diff;
        }

        if (arr[mid] == arr[low] + mid * diff) {
            return findMissingAPHelper(arr, mid + 1, high, diff);
        }

        return findMissingAPHelper(arr, low, mid - 1, diff);


    }
}
