package math;

/**
 * Created by sarvothampai on 05/10/15.
 * <p/>
 * The basic idea is that if x is an overestimate to the square root of a non-negative real number S then
 * S
 * /
 * x
 * will be an underestimate and so the average of these two numbers may reasonably be expected to provide a better approximation (though the formal proof of that assertion depends on the inequality of arithmetic and geometric means that shows this average is always an overestimate of the square root,
 * as noted in the article on square roots, thus assuring convergence).
 * <p/>
 * Complexity : Log()
 * <p/>
 * O(log(log(n/m)) steps
 * <p/>
 * M - is error
 * N is the input
 *
 */
public class SquareRoot {

    public static void main(String[] args) {

        SquareRoot obj = new SquareRoot();
        System.out.println(obj.squareRoot(1005));
    }

    float squareRoot(float n) {
  /*We are using n itself as initial approximation
   This can definitely be improved */
        float x = n;
        float y = n / x;
        float e = 0.001f; /* e decides the accuracy level*/

        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }
        return x;
    }


    /**
     * N is a perfect square
     */
    float squareRoot(int n) {
        int x = n;
        int y = 1;
        while (x > y) {
            x = (x + y) / 2;
            y = n / x;
        }
        return x;
    }

}
