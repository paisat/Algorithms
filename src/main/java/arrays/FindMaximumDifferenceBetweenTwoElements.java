package arrays;

/**
 * Created by sarvothampai on 16/10/15.
 */
public class FindMaximumDifferenceBetweenTwoElements {

    public int maxDiff(int arr[]) {

        int min = arr[0];

        int maxDiff = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - min > maxDiff) {
                maxDiff = arr[i] - min;
            }

            if (arr[i] < min) {
                min = arr[i];

            }

        }

        return maxDiff;


    }
}

