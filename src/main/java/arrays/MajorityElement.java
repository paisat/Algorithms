package arrays;

/**
 * Created by sarvothampai on 04/10/15.
 */
public class MajorityElement {


    public static void main(String[] args) {

        MajorityElement majorityElement = new MajorityElement();

        System.out.println(majorityElement.majorityElement(new int[] { 1, 1, 12, 2, 2, 2, 2, 2, 2, }));

        int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        int arr1[] = { 1, 2, 3, 3, 3, 3, 3,3, 10 };

        //System.out.println(majorityElement.isMajorityElement(arr, -1));
        System.out.println(majorityElement.isMajorityElement(arr1, 3));


    }

    /**
     * When array is not sorted.
     * <p/>
     * Moores voting algorithm
     * <p/>
     * Time Complexity is : O(n)
     */
    public int majorityElement(int[] nums) {

        if (nums != null && nums.length != 0) {


            int majIndex = 0;
            int count = 1;

            for (int i = 1; i < nums.length; i++) {

                if (nums[majIndex] == nums[i]) {
                    count++;
                } else {
                    count--;
                }

                if (count == 0) {
                    majIndex = i;
                    count = 1;
                }

            }

            int majE = nums[majIndex];

            int c = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == majE) {
                    c++;
                }
            }

            if (c > nums.length / 2) {
                return majE;
            } else {

                return Integer.MIN_VALUE;

            }

        }

        return Integer.MIN_VALUE;

    }


    /**
     * Given input is sorted.
     * <p/>
     * Time complexity: O(log n)
     */

    public boolean isMajorityElement(int arr[], int x) {

        if (arr != null && arr.length != 0) {

            int index = binarySearch(arr, 0, arr.length - 1, x);
            if (index == -1) {
                return false;
            }

            if (index + arr.length / 2 <= arr.length - 1 && arr[index + arr.length / 2] == x) {
                return true;
            }

        }

        return false;

    }

    private int binarySearch(int arr[], int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) / 2; /*low + (high - low)/2;*/

        /* Check if arr[mid] is the first occurrence of x.
            arr[mid] is first occurrence if x is one of the following
            is true:
            (i) mid == 0 and arr[mid] == x
            (ii) arr[mid-1] < x and arr[mid] == x
        */
            if ((mid == 0 ||  arr[mid - 1]!=x) && (arr[mid] == x))
                return mid;
            else if (x > arr[mid])
                return binarySearch(arr, mid + 1, high, x);
            else
                return binarySearch(arr, low, mid - 1, x);
        }

        return -1;
    }

}
