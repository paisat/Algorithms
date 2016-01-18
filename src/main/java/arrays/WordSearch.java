package arrays;

/**
 * Created by sarvothampai on 13/11/15.
 * <p/>
 * <p/>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p/>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p/>
 * For example,
 * Given board =
 * <p/>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * <p/>
 * Time Complexity : O(N*N)!
 */
public class WordSearch {

    public static void main(String[] args) {

        WordSearch obj = new WordSearch();

        char board[][] = { { 'C', 'A', 'A' },
                { 'A', 'A', 'A' },
                { 'B', 'C', 'D' } };

        String word = "AAB";

        System.out.println(obj.exist(board, "AAB"));


    }

    public boolean exist(char board[][], String word) {

        boolean result = false;

        if (board != null && board.length != 0 && word != null && word.length() != 0) {

            int row = board.length;
            int col = board[0].length;


            boolean visited[][] = new boolean[row][col];

            for (int i = 0; i < row; i++) {

                for (int j = 0; j < col; j++) {


                    result = wordFinder("" + board[i][j], board, visited, word, i, j, 0);

                    if (result) {
                        return result;
                    }
                }


            }


        }

        return result;
    }

    private boolean wordFinder(String prefix, char board[][], boolean visited[][], String word, int x, int y, int k) {

        visited[x][y] = true;

        if (k > word.length() || prefix.charAt(k) != word.charAt(k)) {
            return false;
        }

        if (prefix.equals(word)) {
            return true;
        }

        int xcor[] = { -1, 1, 0, 0 };
        int ycor[] = { 0, 0, -1, 1 };


        for (int i = 0; i < 4; i++) {

            int x1 = xcor[i] + x;
            int y1 = ycor[i] + y;

            if (isValidChild(x1, y1, board.length, board[0].length, visited)) {
                boolean result = wordFinder(prefix + board[x1][y1], board, visited, word, x1, y1, k + 1);
                if (result) {
                    return result;
                }

            }
        }

        visited[x][y] = false;

        return false;
    }

    private boolean isValidChild(int x, int y, int m, int n, boolean visited[][]) {
        return (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]);
    }


}
