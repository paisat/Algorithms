package dynamicprogramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 18/01/16.
 *
 * Consider the following: let dpX[i][j][k][l] stand for the number of such sequences that ends with X, X is 1,2,3 or 4 with i ones, j twos, k threes, l fours.
 * Then you'll have the formula for dp1:

 dp1[i][j][k][l] = dp2[i-1][j][k][l] + dp3[i-1][j][k][l] + dp4[i-1][j][k][l]
 And the analogous for dp2, dp3 and dp4. The answer will be the dp1[n1][n2][n3][n4] +
 dp2[n1][n2][n3][n4] + dp3[n1][n2][n3][n4] + dp4[n1][n2][n3][n4].

 O(n1*n2*n3*n4)

 *
 */
public class ConsecutiveNumberSeries {

    public static void main(String[] args) {


        ConsecutiveNumberSeries obj = new ConsecutiveNumberSeries();

        System.out.println(obj.compute(1, 1, 1, 1));

        List<Integer> result = new ArrayList<Integer>();

        obj.generateNumber(result, "", new int[] { 1, 1, 1, 1 }, 4);

        System.out.println(result);
        System.out.println(result.size());


    }

    public void generateNumber(List<Integer> result, String number, int[] count, int len) {
        if (number.length() == len) {
            BigInteger num = new BigInteger(number).mod(new BigInteger("1000000007"));
            result.add(new Integer(num.toString()));
            return;
        }

        for (int i = 0; i < 4; ++i) {
            int num = i + 1;
            if (count[i] > 0 && (number.length() == 0
                    || number.charAt(number.length() - 1) - '0' != num)) {
                --count[i];
                generateNumber(result, number + num, count, len);
                ++count[i];
            }
        }
    }

    public int compute(int n1, int n2, int n3, int n4) {


        int MOD = 1000000007;

        int d1[][][][] = new int[50][50][50][50];
        int d2[][][][] = new int[50][50][50][50];
        int d3[][][][] = new int[50][50][50][50];
        int d4[][][][] = new int[50][50][50][50];

        d1[1][0][0][0] = 1;
        d2[0][1][0][0] = 1;
        d3[0][0][1][0] = 1;
        d4[0][0][0][1] = 1;


        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    for (int l = 0; l <= n4; l++) {
                        if (i + j + k + l > 1) {
                            if (i != 0) {
                                d1[i][j][k][l] = d2[i - 1][j][k][l] + d3[i - 1][j][k][l] + d4[i - 1][j][k][l] % MOD;
                            }
                            if (j != 0) {
                                d2[i][j][k][l] = d1[i][j - 1][k][l] + d3[i][j - 1][k][l] + d4[i][j - 1][k][l] % MOD;
                            }
                            if (k != 0) {
                                d3[i][j][k][l] = d2[i][j][k - 1][l] + d1[i][j][k - 1][l] + d4[i][j][k - 1][l] % MOD;
                            }
                            if (l != 0) {
                                d4[i][j][k][l] = d2[i][j][k][l - 1] + d3[i][j][k][l - 1] + d1[i][j][k][l - 1] % MOD;
                            }
                        }
                    }
                }
            }
        }
        return d1[n1][n2][n3][n4] + d2[n1][n2][n3][n4] + d3[n1][n2][n3][n4] + d4[n1][n2][n3][n4] % MOD;
    }
}
