package dynamicprogramming;

/**
 * Created by sarvothampai on 30/11/15.
 * <p/>
 * <p/>
 * Time Complexity : O(n Log n)
 */

//todo complete this
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {

        LongestIncreasingSubSequence obj = new LongestIncreasingSubSequence();

        int arr[] = { 3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10 };

        System.out.println(obj.lengthOfLIS(arr));

    }

    public int lengthOfLIS(int[] nums) {

        int length = 0;

        if (nums != null && nums.length != 0) {


            int r[] = new int[nums.length];

            r[0] = 0;

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] > nums[r[length]]) {
                    length++;
                    r[length] = i;

                } else if (nums[i] < nums[r[0]]) {
                    r[0] = i;
                } else {
                    int index = ceil(r, length, nums, nums[i]);
                    r[index] = i;
                }

            }

            length++;


        }

        return length;
    }

    private int ceil(int arr[], int highIndex, int[] nums, int target) {

        int low = 0;
        int high = highIndex;

        while (low <= high) {

            if (target <= nums[arr[0]]) {
                return arr[0];
            }

            if (target > nums[arr[high]]) {
                return -1;
            }

            int mid = (low + high) / 2;

            if (nums[arr[mid]] == target) {
                return mid;
            }

            if (nums[arr[mid]] < target) {

                if (mid < high && nums[arr[mid + 1]] >= target) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }

            }

            if (nums[arr[mid]] > target) {

                if (mid > 0 && nums[arr[mid - 1]] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }

            }

        }

        return -1;

    }


    /**
     * O(N^2) solution
     *
     *
     */
    public int longestSubsequenceWithActualSolution(int arr[]) {
        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            T[i] = 1;
            actualSolution[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (T[j] + 1 > T[i]) {
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }

        //find the index of max number in T
        int maxIndex = 0;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }

        //lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do {
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        } while (t != newT);
        System.out.println();

        return T[maxIndex];
    }

}
