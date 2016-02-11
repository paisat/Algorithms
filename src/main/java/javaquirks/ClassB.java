package javaquirks;

import java.io.IOException;

/**
 * Created by sarvothampai on 22/10/15.
 */
public class ClassB extends ClassA {


    public ClassB(int i){
        System.out.println("child");
    }

    public static void main(String []args){

        ClassB b=new ClassB(3);

    }


}
