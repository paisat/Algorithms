package arrays;

/**
 * Created by sarvothampai on 19/12/15.
 * <p/>
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
public class FindMaxDifferenceBetweenIndices {

    public static void main(String[] args) {

        FindMaxDifferenceBetweenIndices obj = new FindMaxDifferenceBetweenIndices();

        int arr[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        int arr1[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        int arr2[] = { 1, 2, 3, 4, 5, 6 };


        System.out.println(obj.maxDiffBetweenIndices(arr));
        System.out.println(obj.maxDiffBetweenIndices(arr1));
        System.out.println(obj.maxDiffBetweenIndices(arr2));

    }


    public Integer maxDiffBetweenIndices(int arr[]) {

        Integer result = null;

        if (arr != null && arr.length != 0) {

            int lMin[] = new int[arr.length];
            int rMax[] = new int[arr.length];

            lMin[0] = arr[0];
            rMax[arr.length - 1] = arr[arr.length - 1];

            for (int i = 1; i < arr.length; i++) {
                lMin[i] = Math.min(lMin[i - 1], arr[i]);
            }

            for (int i = arr.length - 2; i >= 0; i--) {
                rMax[i] = Math.max(rMax[i + 1], arr[i]);
            }

            int j = 0;
            int k = 0;

            result = -1;


            while (j < arr.length && k < arr.length) {

                if (lMin[j] > rMax[k]) {
                    j++;
                } else {
                    result = Math.max(result, k - j);
                    k++;
                }
            }


        }

        return result;
    }


}
