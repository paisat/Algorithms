package javaquirks;

/**
 * Created by sarvothampai on 12/11/15.
 */
public class UseOfSuper {


    public static void main(String[] args) {

        SubClass obj = new SubClass();

    }


    protected int b;

    public UseOfSuper() {
        System.out.println("super constructor");
    }

    public UseOfSuper(int a, int b) {
        System.out.println("Super constructor " + a + " " + b);
    }

    public void someMethod(String a) {

        System.out.println("Super Class method " + a);
    }

}


class SubClass extends UseOfSuper {

    public SubClass() {

        super(23, 34);
        super.someMethod("34");
        System.out.println("sub class constructor");
    }

    @Override
    public void someMethod(String a) {

        int b = 34;

        //another super usage
        int ab = super.b;

        //use super to call overidden method
        super.someMethod("23");
        System.out.println("Some Method");

    }

}
