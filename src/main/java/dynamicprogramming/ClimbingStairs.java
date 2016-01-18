package dynamicprogramming;

/**
 * Created by sarvothampai on 18/01/16.
 * <p/>
 * <p/>
 * Time complexity : O(N)
 *
 *
 * For Three steps
 *
 * Let  𝑇(𝑛)  denote the number of different ways for climbing up  𝑛  stairs.
 There are three choices for each first step: either 1, 2, or 3.  T(n)= T(n-1)+ T(n-2)+ T(n-3)
 The boundary conditions :
 when there is only one step,  𝑇(1) = 1 . If only two steps,  𝑇(2) = 2 .   T(3)= 4. ((1,1,1), (1,2), (2,1), (3))
 Pseudo code as below:

 if n is 1
 return 1
 else if n is 2
 return 2
 else
 T[1] = 1
 T[2] = 2
 T[3]=4
 for i = 4 to n do
 T[i] = T[i-1]+T[i-2]+ T[i-3]
 return T[n]
 The time complexity is  Θ(𝑛) .



 *
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int c = 0;

        for (int i = 3; i <= n; i++) {

            c = a + b;
            a = b;
            b = c;

        }

        return c;

    }
}
