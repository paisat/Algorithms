package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 04/10/15.
 */
public class FillMatrixSpirally {


    public static void main(String []args){

        FillMatrixSpirally obj=new FillMatrixSpirally();
        int n=0;
        int [][]matrix = obj.generateMatrix(n);


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }


    }

    public int[][] generateMatrix(int n) {


        if (n!=0) {



            int matrix[][]=new int[n][n];

            int rows = n;
            int col = n;

            int lC = 0, rC = col - 1;
            int tR = 0, bR = rows - 1;

            int k=1; int j=0;


            while (j<n*n) {

                for (int i = lC; i <=rC; i++) {

                    matrix[tR][i]=k;
                    k++;
                }

                tR++;



                for (int i = tR; i <= bR; i++) {
                    matrix[i][rC]=k;
                    k++;
                }

                rC--;


                for (int i = rC; i >=lC; i--) {

                    matrix[bR][i]=k;
                    k++;
                }

                bR--;

                for (int i = bR; i >= tR; i--) {

                    matrix[i][lC]=k;
                    k++;

                }

                lC++;

                j++;
            }

            return matrix;

        }

        return new int[0][];

    }


}
