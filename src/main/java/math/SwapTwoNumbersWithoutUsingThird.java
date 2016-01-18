package math;

/**
 * Created by sarvothampai on 07/01/16.
 */
public class SwapTwoNumbersWithoutUsingThird {

    public static void  main(String []args) {
        int x = 10, y = 5;

        // Code to swap 'x' (1010) and 'y' (0101)
        x = x ^ y;  // x now becomes 15 (1111)
        y = x ^ y;  // y becomes 10 (1010)
        x = x ^ y;  // x becomes 5 (0101)

        System.out.println("x = " + x + "  y = " + y);
    }
}
