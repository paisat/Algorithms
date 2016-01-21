package math;

/**
 * Created by sarvothampai on 20/01/16.
 */
public class IntegralPartOfLogBase2 {


    public static void main(String[] args) {

        IntegralPartOfLogBase2 obj = new IntegralPartOfLogBase2();
        System.out.println(obj.integralPartOfLog(34));


    }

    int integralPartOfLog(int n) {

        int ret = 0;

        while (n > 0) {
            n = n >> 1;
            ret++;
        }

        return ret - 1;
    }
}
