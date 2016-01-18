package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 13/11/15.
 */
public class WordSearch2 {


    public List<String> findWords(char board[][], String words[]) {

        List<String> result =new ArrayList<String>();

        if (board != null && board.length != 0 && words != null && words.length!= 0) {

            int row = board.length;
            int col = board[0].length;


            boolean visited[][] =new boolean[row][col];

            for (int i = 0; i < row; i++) {

                for (int j = 0; j < col; j++) {

                    for(String word :words) {

                        boolean res = wordFinder("" + board[i][j], board, visited, word, i, j, 0);

                        if (res) {
                           result.add(word);
                        }
                    }
                }


            }


        }

        return result;
    }

    private boolean wordFinder(String prefix, char board[][], boolean visited[][], String word, int x, int y, int k) {


        if (k > word.length() || prefix.charAt(k) != word.charAt(k)) {
            return false;
        }

        if (prefix.equals(word)) {
            return true;
        }

        int xcor[] = { -1, 1, 0, 0 };
        int ycor[] = { 0, 0, -1, 1 };


        visited[x][y] = true;


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
