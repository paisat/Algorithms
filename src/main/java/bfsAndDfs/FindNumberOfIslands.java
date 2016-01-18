package bfsAndDfs;

/**
 * Created by sarvothampai on 03/10/15.
 */


/**
 *
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3


 *
 * Time Complexity of DFS is O(V+E) if we use adjaceny graph. if we use matrix then its O(VE).
 * Space Complexity of DFS is O(V)
 *
 * Time Complexity : O(Row x Col)
 *
 *
 *
 * */

public class FindNumberOfIslands {



    public static void main(String[] args) {


        FindNumberOfIslands obj = new FindNumberOfIslands();


        char grid[][] = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        char grid2[][] = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        char grid3[][] = {{'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}
        };

        //System.out.println(obj.numberOfIslands(grid));
        System.out.println(obj.numberOfIslands(grid2));

    }


    public boolean canChildBeReached(int row, int col, int nRow, int nCol, char grid[][], boolean visited[][]) {

        if (((row >= 0 && row <= nRow) && (col >= 0 && col <= nCol))) {

            if ((grid[row][col]) == '1' )
                return true;
            else
                return false;
        }
        return false;
    }

    public void dfs(int row, int col, char grid[][], boolean visited[][]) {

        int nRow[] = {-1, 0, 0, 1};
        int nCol[] = {0, -1, 1, 0};


        if(!visited[row][col]) {
            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {

                if (canChildBeReached(nRow[i] + row, nCol[i] + col,
                        grid.length - 1, grid[0].length - 1, grid, visited)) {

                    dfs(nRow[i] + row, nCol[i] + col, grid, visited);
                }

            }
        }

    }

    public int numberOfIslands(char grid[][]) {

        int numberOfIslands = 0;

        if (grid != null && grid.length != 0) {

            int row = grid.length;
            int col = grid[0].length;

            System.out.println(grid[0].length);


            boolean visited[][] = new boolean[row][col];

            for (int i = 0; i < row; i++) {

                for (int j = 0; j < col; j++) {

                    if (grid[i][j] == '1' && !visited[i][j]) {

                        dfs(i, j, grid, visited);
                        numberOfIslands++;
                    }
                }
            }


        }

        return numberOfIslands;
    }

}
