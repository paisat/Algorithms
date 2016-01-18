package arrays;

/**
 * Created by sarvothampai on 28/11/15.
 * <p/>
 * <p/>
 * Time Complexity : O(n)
 * <p/>
 * Number of comaprisons in naive method = n-1 + n-1 = 2n-2
 * <p/>
 * With this method = 2n-2 - n/2 = 1.5n-2
 */
public class MaximumAndMinimumWithMinimumNumberOfcomparisons {


    public static void main(String[] args) {

        MaximumAndMinimumWithMinimumNumberOfcomparisons obj = new MaximumAndMinimumWithMinimumNumberOfcomparisons();

        int arr[] = { 1, 23, 4, 500 };

        int result[] = obj.findMinAndMax(arr);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    public int[] findMinAndMax(int arr[]) {

        if (arr != null && arr.length != 0) {

            return findMinAndMaxHelper(arr, 0, arr.length - 1);
        }

        return null;

    }


    private int[] findMinAndMaxHelper(int arr[], int low, int high) {

        int result[] = new int[2];
        if (low == high) {
            result[0] = arr[low];
            result[1] = arr[high];
            return result;
        }

        if (low + 1 == high) {

            if (arr[low] > arr[high]) {
                result[1] = arr[low];
                result[0] = arr[high];
            } else {
                result[0] = arr[low];
                result[1] = arr[high];
            }

            return result;
        }

        int mid = low + (high - low) / 2;

        int resultl[] = findMinAndMaxHelper(arr, low, mid);
        int resultr[] = findMinAndMaxHelper(arr, mid + 1, high);

        if (resultl[0] < resultr[0]) {
            result[0] = resultl[0];
        } else {
            result[0] = resultr[0];
        }

        if (resultl[1] > resultr[1]) {
            result[1] = resultl[1];
        } else {
            result[1] = resultr[1];
        }

        return result;

    }
}
