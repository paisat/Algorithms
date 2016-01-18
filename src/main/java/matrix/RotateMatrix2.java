package matrix;

import linkedlist.ListNode;

/**
 * Created by sarvothampai on 11/12/15.
 */
public class RotateMatrix2 {

    public static void main(String[] args) {

        RotateMatrix2 obj = new RotateMatrix2();

        int matrix[][] = { { 1, 2, 3, 4, },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        int matrix1[][] = { { 1, 1 }, { 1, 1 } };

        int matrix2[][] = { { 1, 2, 3, 4 },
                { 7, 8, 9, 10 },
                { 13, 14, 15, 16 },
                { 19, 20, 21, 22 },
                { 25, 26, 27, 28 } };


        obj.rotate(matrix, 2);
        obj.printMatrix(matrix);


        obj.rotate(matrix1, 3);
        obj.printMatrix(matrix1);

        obj.rotate(matrix2,7);
        obj.printMatrix(matrix2);


    }

    private void printMatrix(int mat[][]) {

        if (mat != null && mat.length != 0) {

            int rows = mat.length;
            int cols = mat[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    System.out.print(mat[i][j] + " ");

                }
                System.out.println();
            }

        }

        System.out.println();

    }


    public void rotate(int[][] matrix, int times) {

        if (matrix != null && matrix.length != 0) {


            int rows = matrix.length;
            int cols = matrix[0].length;

            if (rows == 1 || cols == 1) {
                return;
            }

            int tr = 0;
            int br = rows - 1;

            int lc = 0;
            int rc = cols - 1;


            while (tr < br && lc < rc) {

                ListNode head = null;
                int count = 0;

                for (int i = lc; i <= rc; i++) {

                    if (head == null) {
                        head = new ListNode(matrix[tr][i]);
                        head.setPrev(head);
                        head.setNext(head);
                    } else {
                        addToList(head, matrix[tr][i]);
                    }

                    count++;

                }


                for (int i = tr + 1; i <= br; i++) {
                    addToList(head, matrix[i][rc]);
                    count++;
                }


                for (int i = rc - 1; i >= lc; i--) {
                    addToList(head, matrix[br][i]);
                    count++;
                }


                for (int i = br - 1; i >= tr + 1; i--) {
                    addToList(head, matrix[i][lc]);
                    count++;
                }


                head = rotateLinedList(head, times, count);

                for (int i = lc; i <= rc; i++) {

                    matrix[tr][i] = head.getVal();
                    head = head.getNext();
                }

                tr++;

                for (int i = tr; i <= br; i++) {
                    matrix[i][rc] = head.getVal();
                    head = head.getNext();
                }

                rc--;

                for (int i = rc; i >= lc; i--) {

                    matrix[br][i] = head.getVal();
                    head = head.getNext();
                }

                br--;

                for (int i = br; i >= tr; i--) {
                    matrix[i][lc] = head.getVal();
                    head = head.getNext();
                }

                lc++;


            }


        }

    }

    private ListNode rotateLinedList(ListNode head, int k, int count) {

        ListNode cur = head;
        k = k % count;

        if (k != 0) {


            cur = head;

            while (k > 0) {

                cur = cur.getNext();
                k--;

            }

            head = cur;
            cur.getPrev().setNext(null);


        }

        return head;

    }

    private void addToList(ListNode head, int item) {

        ListNode itemNode = new ListNode(item);
        ListNode last = head.getPrev();
        last.setNext(itemNode);
        itemNode.setPrev(last);
        itemNode.setNext(head);
        head.setPrev(itemNode);


    }

}
