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


 Ways to climb 1 stair : 1
 1

 Way to climb 2 stairs : 2
 1,1
 2

 Way to climb 3 stairs : 4
 1,1,1
 1,2
 2,1
 3

 Way to climb 4 stairs :  7

 1,3
 1,1,2
 2,2
 1,1,1,1
 1,2,1
 2,1,1
 3,1




 *
 */
public class ClimbingStairs {

    public static void main(String []args){

        ClimbingStairs obj=new ClimbingStairs();
        System.out.println(obj.climbingStairs3Steps(4));
        System.out.println(obj.climbingStairs3Steps(5));
    }

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

    public int climbingStairs3Steps(int n){

        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        if(n==3){
            return 4;
        }

        int a=1;
        int b=2;
        int c=4;

        for(int i=4;i<=n;i++){
            int d=a+b+c;
            a=b;
            b=c;
            c=d;
        }

        return c;

    }
}
