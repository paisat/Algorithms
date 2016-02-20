package matrix;

/**
 * Created by sarvothampai on 16/10/15.
 * <p/>
 * Rotate Matrix by 90 degrees
 * <p/>
 * <p/>
 * Given an image, how will you turn it by 90 degrees? A vague question.
 * Minimize the browser and try your solution before going further.
 * <p/>
 * An image can be treated as 2D matrix which can be stored in a buffer.
 * We are provided with matrix dimensions and it’s base address. How can we turn it?
 * <p/>
 * <p/>
 *
 * 1    2    3
 * 4    5    6
 * 7    8    9
 * 10   11   12
 */
public class RotateMatrix {

    public static void main(String[] args) {


        RotateMatrix obj = new RotateMatrix();
        int[][] matrix = { { 1, 2, 3 ,4  }, { 5, 6, 7, 8 }, { 9, 10, 11,12 } ,{ 13 ,14 , 15 ,16 } };
//        obj.rotate(matrix);
//        obj.printMatrix(matrix);

        obj.rotate2(matrix);
        obj.printMatrix(matrix);


    }

    private void printMatrix(int matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();

        }


    }

    public void rotate(int[][] matrix) {

        if (matrix != null && matrix.length != 0) {

            int rows = matrix.length;
            int col = matrix[0].length;

            int temp[][] = new int[col][rows];

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < col; j++) {


                    temp[j][rows - 1 - i] = matrix[i][j];

                }

            }

            for (int i = 0; i < col; i++) {
                for (int j = 0; j < rows; j++) {

                    matrix[i][j] = temp[i][j];

                }
            }

        }

    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length, temp;

        for (int i = 0; i < n / 2; i++)

            for (int j = i; j < n - i - 1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
    }
}
