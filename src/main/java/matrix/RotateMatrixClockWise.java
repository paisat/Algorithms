package matrix;

/**
 * Created by sarvothampai on 09/02/16.
 *
 *
 * Rotate a given matrix in clockwise direction;
 *
 * Time Complexity : O(Row x Col)
 *
 */

public class RotateMatrixClockWise {


    public static void main(String[] args) {

        RotateMatrixClockWise obj = new RotateMatrixClockWise();

        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int matrix2[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};



        obj.rotateMatrixClockWise(matrix);
        obj.rotateMatrixClockWise(matrix2);

    }

    public void rotateMatrixClockWise(int matrix[][]) {


        if (matrix != null && matrix.length != 0) {


            int row = matrix.length;
            int cols = matrix[0].length;

            int rt = 0;
            int rb = row - 1;

            int lc = 0;
            int rc = cols - 1;

            while (rt <= rb && lc <= rc) {

                if (rt + 1 > rb) {
                    break;
                }

                int prev = matrix[rt + 1][lc];

                for (int i = lc; i <= rc; i++) {
                    int cur = matrix[rt][i];
                    matrix[rt][i] = prev;
                    prev = cur;
                }

                rt++;

                if (rt > rb) {
                    break;
                }

                for (int i = rt; i <= rb; i++) {
                    int cur = matrix[i][rc];
                    matrix[i][rc] = prev;
                    prev = cur;
                }

                rc--;

                if (rc < lc) {
                    break;
                }


                for (int i = rc; i >= lc; i--) {
                    int cur = matrix[rb][i];
                    matrix[rb][i] = prev;
                    prev = cur;

                }

                rb--;

                if (rb < rt) {
                    break;
                }

                for (int i = rb; i >= rt; i--) {

                    int cur = matrix[i][lc];
                    matrix[i][lc] = prev;
                    prev = cur;
                }


                lc++;

            }


            System.out.println();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println();
            }


        }


    }
}
