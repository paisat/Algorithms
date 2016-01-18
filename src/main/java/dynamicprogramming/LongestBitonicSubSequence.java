package dynamicprogramming;

/**
 * Created by sarvothampai on 30/11/15.
 */

//todo complete this
public class LongestBitonicSubSequence {

    public int longestSequence(int arr[]) {
        int lis[] = new int[arr.length];
        int lds[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < lis[i] + lds[i] - 1) {
                max = lis[i] + lds[i] - 1;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestBitonicSubSequence bs = new LongestBitonicSubSequence();
        int[] arr = { 1, 4, 3, 7, 2, 1, 8, 11, 13, 0 };
        int r = bs.longestSequence(arr);
        System.out.print(r);

    }
}
