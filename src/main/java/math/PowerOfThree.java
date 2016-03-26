package math;

/**
 * Created by sarvothampai on 05/03/16.
 */
public class PowerOfThree {


    public static void main(String []args){

        PowerOfThree obj=new PowerOfThree();

        System.out.println(obj.isPowerOfThree(243));

    }


    public boolean isPowerOfThree(int n) {

        if(n>0){

            double exp=Math.round(Math.log(n)/Math.log(3));

            return (exp%1==0)?true:false;

        }

        return false;

    }
}
