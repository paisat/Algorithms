package arrays;

/**
 * Created by sarvothampai on 01/01/16.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class SeggregateZeroesAndOnes {

    void segregate0and1(int arr[], int size) {
    /* Initialize left and right indexes */
        int left = 0, right = size - 1;

        while (left < right) {
        /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
                left++;

        /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;

        /* If left is smaller than right then there is a 1 at left
          and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}
