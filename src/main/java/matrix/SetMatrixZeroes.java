package matrix;

/**
 * Created by sarvothampai on 20/10/15.
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {

        int arr[][] = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };

    }

    public void setZeroes(int[][] matrix) {


        if (matrix != null && matrix.length != 0) {
            boolean firstRowZero = false;
            boolean firstColumnZero = false;

            int rows = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < col; i++) {
                if (matrix[0][i] == 0) {
                    firstRowZero = true;
                    break;
                }
            }

            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    firstColumnZero = true;
                    break;
                }
            }

            for (int i = 1; i < rows; i++) {

                for (int j = 1; j < col; j++) {

                    if (matrix[i][j] == 0) {

                        matrix[0][j] = 0;
                        matrix[i][0] = 0;

                    }

                }

            }

            for (int i = 1; i < rows; i++) {

                for (int j = 1; j < col; j++) {

                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }

                }

            }

            if (firstRowZero) {

                for (int i = 0; i < col; i++) {
                    matrix[0][i] = 0;
                }
            }

            if (firstColumnZero) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][0] = 0;
                }

            }


        }

    }
}
