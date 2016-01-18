package arrays;

/**
 * Created by sarvothampai on 19/12/15.
 * <p/>
 * Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j].
 * Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
 * Expected time complexity of the solution is O(n)
 * <p/>
 * Simple Examples
 * 1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78, 90, 45, 23} which is of length 5.
 * <p/>
 * 2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.
 * <p/>
 * Extreme Examples
 * 1) A[] = {10}, the single element is bitnoic, so output is 1.
 * <p/>
 * 2) A[] = {10, 20, 30, 40}, the complete array itself is bitonic, so output is 4.
 * <p/>
 * 3) A[] = {40, 30, 20, 10}, the complete array itself is bitonic, so output is 4.
 * <p/>
 *
 * Time Complexity: O(N)
 */
public class MaximumLengthBitonicSubArray {

    public static void main(String[] args) {
        int arr[] = { 12, 4, 78, 90, 45, 23 };

        MaximumLengthBitonicSubArray obj = new MaximumLengthBitonicSubArray();
        System.out.println(obj.maxBitonicSubArray(arr));

    }


    public int maxBitonicSubArray(int arr[]) {


        int result = 0;

        if (arr != null && arr.length != 0) {


            int inc[] = new int[arr.length];
            int dec[] = new int[arr.length];

            inc[0] = 1;
            dec[arr.length - 1] = 1;

            for (int i = 1; i < arr.length; i++) {

                if (arr[i] > arr[i - 1]) {
                    inc[i] = inc[i - 1] + 1;
                } else {
                    inc[i] = 1;
                }
            }

            for (int i = arr.length - 2; i >= 0; i--) {

                if (arr[i] > arr[i + 1]) {
                    dec[i] = dec[i + 1] + 1;
                } else {
                    dec[i] = 1;
                }

            }

            result = inc[0] + dec[0] - 1;

            for (int i = 1; i < inc.length; i++) {
                if (inc[i] + dec[i] - 1 > result) {
                    result = inc[i] + dec[i] - 1;
                }
            }


        }

        return result;


    }
}
