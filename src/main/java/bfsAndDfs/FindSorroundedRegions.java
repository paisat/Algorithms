package bfsAndDfs;

import java.util.Stack;

/**
 * Created by sarvothampai on 03/10/15.
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X


 Time complexity is O(MN)

 *
 */


public class FindSorroundedRegions {


    public static void main(String[] args) {
        FindSorroundedRegions obj = new FindSorroundedRegions();

        char grid[][] = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        obj.solve(grid);


    }


    public boolean canChildBeReached(int row, int col, int nRow, int nCol, char grid[][]) {

        return ((row >= 0 && row <= nRow - 1) && (col >= 0 && col <= nCol - 1) && grid[row][col] == 'O');
    }

    private class Child {

        private int row;
        private int col;

        public Child(int row, int col) {
            this.row = row;
            this.col = col;
        }


        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    public void dfs(int row, int col, int nRow, int nCol, char grid[][], boolean visited[][]) {

        int nRows[] = {-1, 0, 0, 1};
        int nCols[] = {0, -1, 1, 0};

        Stack<Child> childrenStack = new Stack<Child>();
        childrenStack.add(new Child(row, col));

        while (!childrenStack.isEmpty()) {

            Child child = childrenStack.pop();
            int row1 = child.getRow();
            int col1 = child.getCol();

            for (int i = 0; i < 4; i++) {

                int r = nRows[i] + row1;
                int c = nCols[i] + col1;

                if (canChildBeReached(r, c, nRow, nCol, grid)) {

                    grid[r][c] = '#';
                    childrenStack.add(new Child(r, c));
                }
            }


        }
    }

    public void solve(char[][] board) {


        if (board != null && board.length != 0) {

            int row = board.length;
            int col = board[0].length;

            boolean visited[][] = new boolean[row][col];

            for (int i = 0; i < col; i++) {

                if (board[0][i] == 'O' && !visited[0][i]) {
                    board[0][i] = '#';
                    dfs(0, i, row, col, board, visited);
                }

            }

            for (int i = 0; i < row; i++) {

                if (board[i][0] == 'O' && !visited[i][0]) {
                    board[i][0] = '#';
                    dfs(i, 0, row, col, board, visited);
                }

            }

            for (int i = 0; i < col; i++) {

                System.out.println(board[row - 1][i]);
                if (board[row - 1][i] == 'O' && !visited[row - 1][i]) {
                    board[row - 1][i] = '#';
                    dfs(row - 1, i, row, col, board, visited);
                }

            }

            for (int i = 0; i < row; i++) {

                if (board[i][col - 1] == 'O' && !visited[i][col - 1]) {
                    board[i][col - 1] = '#';
                    dfs(i, col - 1, row, col, board, visited);
                }

            }


            for (int i = 0; i < row; i++) {

                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {

                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }


                }

            }

        }

    }


}
