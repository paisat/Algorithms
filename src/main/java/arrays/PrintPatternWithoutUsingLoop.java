package arrays;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * Print a pattern without using any loop
 * Given a number n, print following pattern without using any loop.
 * <p/>
 * Input: n = 16
 * Output: 16, 11, 6, 1, -4, 1, 6, 11, 16
 * <p/>
 * Input: n = 10
 * Output: 10, 5, 0, 5, 10
 *
 *
 */
public class PrintPatternWithoutUsingLoop {

    public static void main(String[] args) {

        PrintPatternWithoutUsingLoop obj = new PrintPatternWithoutUsingLoop();
        obj.printPattern(16);
    }

    public void printPattern(int n) {

        if (n < 0 || n == 0) {
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");

        printPattern(n - 5);

        System.out.print(n + " ");
    }

}
