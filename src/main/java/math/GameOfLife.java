package math;

/**
 * Created by sarvothampai on 20/10/15.
 * <p/>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p/>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p/>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p/>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array.
 * In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 * <p/>
 * <p/>
 * To solve it in place, we use 2 bits to store 2 states:
 * <p/>
 * [2nd bit, 1st bit] = [next state, current state]
 * <p/>
 * - 00  dead (next) <- dead (current)
 * - 01  dead (next) <- live (current)
 * - 10  live (next) <- dead (current)
 * - 11  live (next) <- live (current)
 * In the beginning, every cell is either 00 or 01.
 * Notice that 1st state is independent of 2nd state.
 * Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
 * Let's count # of neighbors from 1st state and set 2nd state bit.
 * Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
 * In the end, delete every cell's 1st state by doing >> 1.
 * For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.
 * <p/>
 * Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
 * Transition 00 -> 10: when board == 0 and lives == 3.
 * To get the current state, simply do
 * <p/>
 * board[i][j] & 1
 * To get the next state, simply do
 * <p>
 *
 * Time Complexity : O(Row * Col)
 */
public class GameOfLife {

    public static void main(String[] args) {

        int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 } };
        GameOfLife obj = new GameOfLife();
        obj.gameOfLife(board);

    }

    public void gameOfLife(int[][] board) {

        if (board != null && board.length != 0) {

            int rows = board.length;
            int col = board[0].length;

            int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < col; j++) {


                    int liveCells = 0;

                    for (int k = 0; k < 8; k++) {

                        int childX = i + x[k];
                        int childY = j + y[k];
                        if (isAValidChild(childX, childY, rows, col)) {

                            if ((board[childX][childY] & 1) == 1) {
                                liveCells++;
                            }
                        }

                    }


                    if ((board[i][j] & 1) == 1 && (liveCells == 2 || liveCells == 3)) {
                        board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                    }
                    if ((board[i][j] & 1) == 0 && liveCells == 3) {
                        board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                    }

                }

            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] >>= 1;  // Get the 2nd state.
                }
            }


        }

    }

    private boolean isAValidChild(int row, int col, int rows, int cols) {
        return ((row >= 0 && row < rows) && (col >= 0 && col < cols));

    }
}
