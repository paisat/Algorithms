package primenumbers;

/**
 * Created by sarvothampai on 03/10/15.
 */


public class FindNumberOfPrimeNumbers {



    public static void main(String []args){

        FindNumberOfPrimeNumbers obj=new FindNumberOfPrimeNumbers();
        System.out.println(obj.countPrimes(120));

    }

    public int countPrimes(int n) {


        int count = 0;

        if (n >= 2) {


            boolean[] marked = new boolean[n + 1];

            for (int i = 2; i <n  ; i++) {

                if (!marked[i]) {
                    count++;

                    int a = 2;
                    if(i>Math.sqrt(n)){
                        break;
                    }


                    while (i * a <= n) {

                        marked[i * a] = true;
                        a++;
                    }
                }
            }

        }

        return count;

    }

}
