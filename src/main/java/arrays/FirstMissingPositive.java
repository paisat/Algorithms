package arrays;

/**
 * Created by sarvothampai on 19/10/15.
 * <p/>
 * <p/>
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class FirstMissingPositive {

    public static void main(String[] args) {

        FirstMissingPositive obj = new FirstMissingPositive();

        int nums[] = { -10, -3, -100, -1000, -239, 1 };

        System.out.println(obj.firstMissingPositive(nums));

    }


    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length) i++;
            else if (A[A[i] - 1] != A[i]) swap(A, i, A[i] - 1);
            else i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1) i++;
        return i + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
