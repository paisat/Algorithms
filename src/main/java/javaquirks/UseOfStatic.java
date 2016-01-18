package javaquirks;

/**
 * Created by sarvothampai on 12/11/15.
 */
public  class UseOfStatic {


    public static int staticVariable=23;

    public static void staticMethod(String s){
        System.out.println("I am static method "+s);
    }

    public void method(){
        System.out.println("non static method");
    }

}


