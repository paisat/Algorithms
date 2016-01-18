package arrays;

/**
 * Created by sarvothampai on 17/10/15.
 * <p/>
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x.
 * Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.
 * <p/>
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0:    floor doesn't exist in array,  ceil  = 1
 * For x = 1:    floor  = 1,  ceil  = 1
 * For x = 5:    floor  = 2,  ceil  = 8
 * For x = 20:   floor  = 19,  ceil doesn't exist in array
 * <p/>
 * <p/>
 * Time Complexity : O(Log n)
 */


public class FloorAndCeilingOfANumber {

    public static void main(String[] args) {

        FloorAndCeilingOfANumber obj = new FloorAndCeilingOfANumber();

        int arr[] = { 1, 2, 8, 10, 10, 12, 19 };

        System.out.println(obj.ceilingOfAnumber(arr, 3));
        System.out.println(obj.floorOfANumber(arr, 13));


    }

    private int floorOfANumber(int arr[], int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            if (arr[high] <= x) {
                return arr[high];
            }

            if (x < arr[low]) {
                return -1;
            }

            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return arr[mid];
            }

            if (arr[mid] > x) {

                if (mid > low && arr[mid - 1] <= x) {
                    return arr[mid - 1];
                } else {
                    high = mid - 1;
                }

            } else {

                if (mid < high && arr[mid + 1] > x) {
                    return arr[mid];
                } else {
                    low = mid + 1;
                }

            }

        }

        return -1;

    }


    private int ceilingOfAnumber(int arr[], int x) {


        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            if (x <= arr[low]) {
                return arr[low];
            }

            if (x > arr[high]) {
                return -1;
            }

            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                return arr[mid];
            }

            if (arr[mid] < x) {

                if (mid < high && arr[mid + 1] >= x) {
                    return arr[mid + 1];
                } else {
                    low = mid + 1;
                }

            } else {

                if (mid > low && arr[mid - 1] < x) {
                    return mid;
                } else {
                    high = mid - 1;
                }


            }

        }

        return -1;

    }

}
