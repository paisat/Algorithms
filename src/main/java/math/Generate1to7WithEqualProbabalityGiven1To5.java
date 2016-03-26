package math;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sarvothampai on 13/03/16.
 * <p/>
 * <p/>
 * Todo Google
 * <p/>
 * <p/>
 * My take on explaining why this is correct: Say that I want to write a program that outputs a stream of uniform random numbers from1 to 25;
 * for that I'd just return 5 * (rand5() - 1) + rand5() as in the code in the answer.
 * Now, if I want to build a stream of uniform random numbers between 1 and 21, if I just use the first stream but filter it so that numbers in [22, 25] are rejected, I can build that stream too.
 * Next, if I take this stream and filter it so that for each element x I output x % 7 + 1, I have a stream of uniform random numbers from 1 to 7!
 */
public class Generate1to7WithEqualProbabalityGiven1To5 {


    public static void main(String[] args) {

        Generate1to7WithEqualProbabalityGiven1To5 obj = new Generate1to7WithEqualProbabalityGiven1To5();
        System.out.println(obj.generate1to7());
    }

    public int generate1To5() {
        return ThreadLocalRandom.current().nextInt(1, 6);
    }


    public int generate1to7() {

        int num;
        do {

            num = 5 * (generate1To5() - 1) + generate1To5();
        } while (num > 21);

        return (num % 7) + 1;

    }

}
