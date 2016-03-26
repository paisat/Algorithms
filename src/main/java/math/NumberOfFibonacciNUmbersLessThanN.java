package math;

/**
 * Created by sarvothampai on 14/03/16.
 * <p/>
 * <p/>
 * A number is a fibonacci number if 5*N*N+4 or 5*N*N-4 is a perfect square
 */
public class NumberOfFibonacciNUmbersLessThanN {


    public static void main(String[] args) {

        NumberOfFibonacciNUmbersLessThanN obj = new NumberOfFibonacciNUmbersLessThanN();
        System.out.println(obj.numberOfFibonacciNumbersLessThanN(14930352));
    }

    public int numberOfFibonacciNumbersLessThanN(int n) {

        if (n >= 0) {
            int count = 0;
            for (long i = 0; i <= n; i++) {
                if (isPerfectSquare(5 * i * i + 4) || isPerfectSquare(5 * i * i - 4)) {
                    count++;
                }
            }

            if (n >= 1) {
                count++;
            }

            return count;
        }

        return 0;
    }

    private boolean isPerfectSquare(long n) {

        if (Math.sqrt(n) % 1 == 0) {
            return true;
        }
        return false;
    }


}
