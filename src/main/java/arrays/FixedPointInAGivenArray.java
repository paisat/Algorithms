package arrays;

/**
 * Created by sarvothampai on 29/11/15.
 * <p/>
 * <p/>
 * Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array,
 * if there is any Fixed Point present in array, else returns -1.
 * Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative.
 * <p/>
 * Examples:
 * <p/>
 * Input: arr[] = {-10, -5, 0, 3, 7}
 * Output: 3  // arr[3] == 3
 * <p/>
 * Input: arr[] = {0, 2, 5, 8, 17}
 * Output: 0  // arr[0] == 0
 * <p/>
 * <p/>
 * Input: arr[] = {-10, -5, 3, 4, 7, 9}
 * Output: -1  // No Fixed Point
 * <p/>
 * <p/>
 * Time complexity : O(log N)
 */


public class FixedPointInAGivenArray {


    public static void main(String[] args) {

        FixedPointInAGivenArray obj = new FixedPointInAGivenArray();

        int arr[] = { -10, -5, 0, 3, 7 };
        int arr1[] = { -10, -5, 3, 4, 7, 9 };

        System.out.println(obj.findFixedElement(arr));
        System.out.println(obj.findFixedElement(arr1));

    }


    public boolean findFixedElement(int arr[]) {


        if (arr != null && arr.length != 0) {

            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (mid == arr[mid]) {
                    return true;
                }

                if (arr[mid] < mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }

        return false;

    }

}
