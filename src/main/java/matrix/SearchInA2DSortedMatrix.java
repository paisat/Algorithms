package matrix;

/**
 * Created by sarvothampai on 16/10/15.
 * <p/>
 * Time  Complexity is O(M+N)
 */
public class SearchInA2DSortedMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {


        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols - 1;


        while (i < rows && j >= 0) {

            if (matrix[i][j] == target) {
                return true;
            }


            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }


        }

        return false;

    }
}
