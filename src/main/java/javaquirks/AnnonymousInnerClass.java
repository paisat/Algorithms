package javaquirks;

/**
 * Created by sarvothampai on 26/12/15.
 */

public class AnnonymousInnerClass {


    public static void main(String []args){

        Test test=new Test() {
            public void method1() {
                System.out.println("test");
            }
        };

        test.method1();

        TestAbstract testAbstract=new TestAbstract() {
            @Override
            public void function1() {
                System.out.println("test abstract class");
            }
        };


        testAbstract.function1();

    }

}

interface Test{
    public void method1();
}

abstract class TestAbstract{
    public abstract void function1();
}
