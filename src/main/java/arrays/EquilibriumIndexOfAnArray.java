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
