package arrays;

/**
 * Created by sarvothampai on 13/11/15.
 * <p/>
 * Follow up for "Unique Paths":
 * <p/>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p/>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p/>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p/>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p/>
 * <p/>
 * Time Complexity : O(m*n)
 */
public class UniquePathsRobotWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int result = 0;


        if (obstacleGrid != null && obstacleGrid.length != 0) {

            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;

            int dp[][] = new int[row][col];


            dp[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

            for (int i = 1; i < row; i++) {
                if (dp[i - 1][0] != 0 && obstacleGrid[i][0] != 1) {
                    dp[i][0] = 1;
                }
            }

            for (int i = 1; i < col; i++) {
                if (dp[0][i - 1] != 0 && obstacleGrid[0][i] != 1) {
                    dp[0][i] = 1;
                }
            }


            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] =dp[i][j-1]+dp[i-1][j];
                    }
                }
            }

            result = dp[row - 1][col - 1];


        }

        return result;

    }
}
