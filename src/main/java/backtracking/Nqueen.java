package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 03/01/16.
 * <p/>
 * Time Complexity : O(N!)
 */
public class Nqueen {


    public List<List<String>> solveNQueens(int n) {


        List<List<String>> result = new ArrayList<List<String>>();


        if (n > 0) {


            solveNQueenUtil(result, 0, n);
        }

        return result;
    }


    private boolean solveNQueenUtil(List<List<String>> board, int col, int n) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {


            if (isSafe(board, i, col, n)) {

                board.get(i).set(col, "Q");
                if (solveNQueenUtil(board, col + 1, n)) {
                    return true;
                }

                board.get(i).set(col, ".");

            }


        }

        return false;

    }

    private boolean isSafe(List<List<String>> board, int row, int col, int n) {


        for (int i = 0; i < col; i++) {
            if (board.get(row).get(i).equals("Q")) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {

            if (board.get(i).get(j).equals("Q")) {
                return false;
            }
        }

        for (int i = row, j = col; i < n && j >= 0; i++, j--) {

            if (board.get(i).get(j).equals("Q")) {
                return false;
            }

        }

        return true;
    }

}
