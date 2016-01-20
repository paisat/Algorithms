package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 19/12/15.
 * <p/>
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an arrya A:
 * <p/>
 * A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
 * <p/>
 * 3 is an equilibrium index, because:
 * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
 * <p/>
 * 6 is also an equilibrium index, because sum of zero elements is zero, i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0
 * <p/>
 * 7 is not an equilibrium index, because it is not a valid index of array A.
 * <p/>
 * Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n, returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(n)
 */
public class EquilibriumIndexOfAnArray {

    public static void main(String[] args) {


        EquilibriumIndexOfAnArray obj = new EquilibriumIndexOfAnArray();

        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };

        System.out.println(obj.equilibriumIndex(arr));

    }


    /**
     *
     * Time Complexity : O(N^2)
     *
     * */
    int equilibrium(int arr[], int n) {
        int i, j;
        int leftsum, rightsum;

  /* Check for indexes one by one until an equilibrium
    index is found */
        for (i = 0; i < n; ++i) {
            leftsum = 0;  // initialize left sum for current index i
            rightsum = 0; // initialize right sum for current index i

    /* get left sum */
            for (j = 0; j < i; j++)
                leftsum += arr[j];

    /* get right sum */
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];

    /* if leftsum and rightsum are same, then we are done */
            if (leftsum == rightsum)
                return i;
        }

  /* return -1 if no equilibrium index is found */
        return -1;
    }

    public List<Integer> equilibriumIndex(int arr[]) {

        List<Integer> indexes = new ArrayList<Integer>();

        if (arr != null && arr.length != 0) {


            int rightSum = 0;

            int leftSum = 0;

            for (int i : arr) {
                rightSum += i;
            }

            for (int i = 0; i < arr.length; i++) {

                rightSum = rightSum - arr[i];

                if (rightSum == leftSum) {
                    indexes.add(i);
                }

                leftSum = leftSum + arr[i];

            }


        }

        return indexes;

    }

}
