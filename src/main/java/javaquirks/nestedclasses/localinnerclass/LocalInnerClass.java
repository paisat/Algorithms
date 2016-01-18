package javaquirks.nestedclasses.localinnerclass;

/**
 * Created by sarvothampai on 15/01/16.
 */
public class LocalInnerClass {

    public void method(){


         class testClass{

            public void method(){

            }
        }

        testClass obj=new testClass();
        obj.method();


    }
}
