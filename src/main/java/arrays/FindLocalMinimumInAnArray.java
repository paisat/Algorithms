package arrays;

/**
 * Created by sarvothampai on 29/11/15.
 * <p/>
 * Find Local Minimum in an array
 * <p/>
 * Time Complexiy : O(log N)
 *
 *
 * Array need not be sorted
 *
 */


public class FindLocalMinimumInAnArray {


    public static void main(String[] args) {

        FindLocalMinimumInAnArray bj = new FindLocalMinimumInAnArray();

        int arr[] = { 5, 2, 4, 6 };

        System.out.println(bj.findLocalMinimum(arr));

    }

    public Integer findLocalMinimum(int arr[]) {

        if (arr != null && arr.length != 0) {


            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if ((mid == 0 || arr[mid] < arr[mid - 1]) && ((mid == arr.length - 1) || arr[mid] < arr[mid + 1])) {
                    return arr[mid];
                }

                if (arr[mid - 1] < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }


        }

        return null;
    }

}
