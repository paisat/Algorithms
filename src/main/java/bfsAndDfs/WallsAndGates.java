package bfsAndDfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by sarvothampai on 03/10/15.
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 -1 - A wall or an obstacle.
 0 - A gate.


 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF

 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 *
 *
 *
 */


public class WallsAndGates {


    public static void main(String[] args) {

        WallsAndGates obj = new WallsAndGates();

        int rooms[][] = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        int room1[][]={{0,Integer.MAX_VALUE}};

        int room2[][] = {{0,Integer.MAX_VALUE,0},{Integer.MAX_VALUE,-1,Integer.MAX_VALUE},{-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};


        obj.findPath(room2);

    }


    private class Child {

        int row;
        int col;

        public Child(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {

            return col;
        }
    }


    public boolean isAValidChild(int row, int col, int nRow, int nCol, int[][] rooms) {

        return ((row >= 0 && row <= nRow - 1) && (col >= 0 && col <= nCol - 1) && rooms[row][col] != -1 && rooms[row][col] != 0);
    }

    public void bfs(int row, int col, int nRow, int nCol, int[][] rooms, boolean visited[][]) {


        int nRows[] = {-1, 0, 0, 1};
        int nCols[] = {0, -1, 1, 0};

        Queue<Child> frontier = new ArrayDeque<Child>();

        frontier.add(new Child(row, col));

        while (!frontier.isEmpty()) {

            Child current = frontier.poll();
            visited[current.getRow()][current.getCol()] = true;

            for (int i = 0; i < 4; i++) {

                int r = current.getRow() + nRows[i];
                int c = current.getCol() + nCols[i];

                Child child = new Child(r, c);

                if (isAValidChild(r, c, nRow, nCol, rooms) && !frontier.contains(child) && !visited[r][c]) {

                    frontier.add(child);
                    int distance = rooms[current.getRow()][current.getCol()] + 1;

                    if (distance < rooms[r][c]) {
                        rooms[r][c] = distance;
                    }


                }


            }

        }

    }

    public void findPath(int[][] rooms) {

        if (rooms != null && rooms.length != 0) {


            int rows = rooms.length;
            int cols = rooms[0].length;

            boolean visited[][] = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (rooms[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j, rows, cols, rooms, visited);
                        visited = new boolean[rows][cols];
                    }
                }
            }


//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j < cols; j++) {
//
//                    System.out.print(rooms[i][j] + " ");
//
//                }
//
//                System.out.println();
//            }


        }

    }

}

