package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 04/10/15.
 *
 * Print Matrix in Spiral form
 *
 * Time Complexity : O(MN)
 *
 */


public class PrintMatrixSpirally {


    public static void main(String[] args) {

        int matrix[][] = {
                {
                        1, 2, 3
                },
                {
                        4, 5, 6
                },
                {
                        7, 8, 9
                }};


        int matrix1[][]={{7},{9},{6}};


        PrintMatrixSpirally obj=new PrintMatrixSpirally();

        System.out.println(obj.spiralOrder(matrix));


    }


    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> result = new ArrayList<Integer>();

        if (matrix != null && matrix.length != 0) {

            int rows = matrix.length;
            int col = matrix[0].length;

            int lC = 0, rC = col - 1;
            int tR = 0, bR = rows - 1;


            while (lC <= rC && tR <= bR) {

                for (int i = lC; i <=rC; i++) {
                    result.add(matrix[tR][i]);
                }

                tR++;

                if(tR>bR){
                    break;
                }


                for (int i = tR; i <= bR; i++) {
                    result.add(matrix[i][rC]);
                }

                rC--;

                if(rC<lC){
                    break;
                }



                for (int i = rC; i >=lC; i--) {
                    result.add(matrix[bR][i]);
                }

                bR--;

                for (int i = bR; i >= tR; i--) {

                    result.add(matrix[i][lC]);

                }

                lC++;
            }

        }

        return result;

    }

}

