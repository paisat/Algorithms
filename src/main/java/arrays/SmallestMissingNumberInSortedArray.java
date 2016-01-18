package arrays;

/**
 * Created by sarvothampai on 19/12/15.
 * <p/>
 * Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n.
 * Find the smallest number that is missing from the array.
 * <p/>
 * Examples
 * Input: {0, 1, 2, 6, 9}, n = 5, m = 10
 * Output: 3
 * <p/>
 * Input: {4, 5, 10, 11}, n = 4, m = 12
 * Output: 0
 * <p/>
 * Input: {0, 1, 2, 3}, n = 4, m = 5
 * Output: 4
 * <p/>
 * Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
 * Output: 8
 * <p/>
 * <p/>
 * Time Complexity : log(n)
 */

public class SmallestMissingNumberInSortedArray {

    public static void main(String[] args) {

        SmallestMissingNumberInSortedArray obj = new SmallestMissingNumberInSortedArray();

        int arr[] = { 0, 1, 2, 6, 9 };
        int arr1[] = { 4, 5, 10, 11 };
        int arr2[] = { 0, 1, 2, 3 };
        int arr3[] = { 0, 1, 2, 3, 4, 5, 6, 7, 10 };

        System.out.println(obj.smallestMissingNumber(arr));
        System.out.println(obj.smallestMissingNumber(arr1));
        System.out.println(obj.smallestMissingNumber(arr2));
        System.out.println(obj.smallestMissingNumber(arr3));

    }


    public Integer smallestMissingNumber(int arr[]) {

        Integer result = null;

        if (arr != null && arr.length != 0) {

            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {

                int mid = low + ((high - low) / 2);

                if (arr[low] != low) {
                    return low;
                }

                if (mid < arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }

            }

            //required for inputs like {0,1,2,3}
            return high + 1;


        }

        return result;

    }

}
