package arrays;

/**
 * Created by sarvothampai on 16/01/16.
 */

public class ArrayDisp {
    public static void main(String arg[]) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[][] represent = ArrayDisp.represent(a, 4);


    }

    public static int[][] represent(int[] a, int cols) {
        int size = a.length;
        int elementsPerCol = size / cols;
        int remain = size % cols;
        int[][] output;

        if (remain <= 0)
            output = new int[elementsPerCol][cols];
        else
            output = new int[elementsPerCol + 1][cols];

        int k = 0;
        for (int i = 0; i < output[0].length; i++) {
            for (int j = 0; j < output.length - 1; j++) {
                if (k >= a.length) {
                    return output;
                }
                output[j][i] = a[k];
                //System.out.println("row: " + j + " col: " + i + " = " + a[k]);
                k++;
            }
            if (remain > 0) {
                output[output.length - 1][i] = a[k];
                //System.out.println("row: " + (output.length - 1) + " col: " + i + " = " + a[k]);
                remain--;
                k++;
            }

        }

        for(int i=0;i<output.length;i++){
            for(int j=0;j<output[0].length;j++){
                System.out.print(output[i][j] + " ");
            }

            System.out.println();

        }

        return output;
    }
}
