package hash;

import java.util.HashSet;

/**
 * Created by sarvothampai on 10/12/15.
 * <p/>
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p/>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {


    public boolean isValidSudoku(char[][] board) {

        boolean isValid = false;

        if (board != null && board.length != 0) {

            isValid = true;
            HashSet<String> set = new HashSet<String>();

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {

                    if (board[i][j] != '.') {

                        String number = "(" + board[i][j] + ")";

                        if (!set.add(i + number) || !set.add(number + j) || !set.add(i / 3 + number + j / 3)) {
                            return false;
                        }
                    }

                }
            }

        }


        return isValid;
    }

}
