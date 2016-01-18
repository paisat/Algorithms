package hash;

import java.util.HashSet;

/**
 * Created by sarvothampai on 10/12/15.
 *
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits,
 and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1


 Space Complexity :

 *
 */
public class HappyNumber {

    public static void main(String []args){

        HappyNumber obj =new HappyNumber();

        System.out.println(obj.isHappy(2));

    }


    public boolean isHappy(int n) {


        if (n > 0) {

            HashSet<Integer> set = new HashSet<Integer>();

            int sum;


            while (!set.contains(n)) {

                if (n == 1) {
                    return true;
                }


                set.add(n);
                sum=0;


                while (n != 0) {

                    int r = n % 10;
                    n = n / 10;
                    sum = sum + r * r;

                }

                n=sum;


            }


        }

        return false;

    }
}
