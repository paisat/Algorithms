package math;

/**
 * Created by sarvothampai on 01/02/16.
 */
public class FloatOverFlow {


    public static void main(String []args){

        FloatOverFlow obj=new FloatOverFlow();
        obj.doesFloatOverFlow();

    }

    public void doesFloatOverFlow(){


        System.out.println("Max Value"+Float.MAX_VALUE);
        System.out.println("Min Value"+ Float.MIN_VALUE);

        System.out.println(Math.abs(Float.MIN_VALUE)-  Math.floor(Math.abs(Float.MIN_VALUE)));

    }

}
