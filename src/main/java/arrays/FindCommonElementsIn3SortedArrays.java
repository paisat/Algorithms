package arrays;

/**
 * Created by sarvothampai on 06/01/16.
 * <p/>
 * <p/>
 * Time Complexity O(n1+n2+n3)
 */
public class FindCommonElementsIn3SortedArrays {

    void findCommon(int ar1[], int ar2[], int ar3[], int n1, int n2, int n3) {
        // Initialize starting indexes for ar1[], ar2[] and ar3[]
        int i = 0, j = 0, k = 0;

        // Iterate through three arrays while all arrays have elements
        while (i < n1 && j < n2 && k < n3) {
            // If x = y and y = z, print any of them and move ahead
            // in all arrays
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                System.out.println(ar1[i] + " " + ar2[j] + " " + ar3[k]);
                i++;
                j++;
                k++;

            }

            // x < y
            else if (ar1[i] < ar2[j])
                i++;

                // y < z
            else if (ar2[j] < ar3[k])
                j++;

                // We reach here when x > y and z < y, i.e., z is smallest
            else
                k++;
        }
    }
}
