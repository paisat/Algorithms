package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * Given two arrays were digits of one array represent a number,maxmise the number by replacing it with elements of second array.
 * eg:
 * arr={3,1,4,5,6}
 * rep={1,9,5,2,3}
 * <p/>
 * after replacement
 * arr={9,5,4,5,6}
 * one digit of rep can be used to replace only once.
 */
public class MaxArray {


    // T(n) = O(N+1 * logN)
    public int[] maximizeArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0) {
            return null;
        }
        Arrays.sort(arr2);

        int index2 = arr2.length - 1;
        for (int i = 0; i < arr1.length; i++) {
            if (index2 >= 0 && arr1[i] < arr2[index2]) {
                arr1[i] = arr2[index2];
                index2--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        MaxArray m = new MaxArray();
        int[] arr1 = { 3, 1, 4, 5, 6 };
        int[] arr2 = { 2, 9 };
        System.out.println(Arrays.toString(m.maximizeArray(arr1, arr2)));
    }

}

