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
 *
 */
public class RotateMatrix {

    public static void main(String[] args) {


        RotateMatrix obj = new RotateMatrix();
        int[][] matrix = { { 1 } };
        obj.rotate(matrix);


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
}
