package arrays;

/**
 * Created by sarvothampai on 25/10/15.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }


        int length = nums.length;

        k = k % length;

        if (k != 0) {

            k = length - k;

            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, length - 1);
            reverseArray(nums, 0, length - 1);


        }

    }

    private void reverseArray(int arr[], int low, int high) {

        int length = high - low + 1;

        for (int i = 0; i < length / 2; i++) {

            int temp = arr[low + i];
            arr[low + i] = arr[high - i];
            arr[high - i] = temp;

        }


    }
}
