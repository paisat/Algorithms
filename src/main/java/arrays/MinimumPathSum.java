package arrays;

/**
 * Created by sarvothampai on 13/11/15.
 * <p/>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p/>
 * Note: You can only move either down or right at any point in time.
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(mn)
 * Space Complexity : O(mn)
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int result = 0;


        if (grid != null && grid.length != 0) {


            int row = grid.length;
            int col = grid[0].length;

            int dp[][] = new int[row][col];
            dp[0][0] = grid[0][0];

            for (int i = 1; i < col; i++) {
                dp[0][i] = grid[0][i] + dp[0][i - 1];
            }

            for (int i = 1; i < row; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }

            for (int i = 1; i < row; i++) {

                for (int j = 1; j < col; j++) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }


            }

            result = dp[row - 1][col - 1];

        }


        return result;

    }
}
