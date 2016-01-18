package javaquirks.nestedclasses;

/**
 * Created by sarvothampai on 15/01/16.
 *
 * Outer class can access private members of inner nested class for both static and non static.
 *
 *
 */
public class NestedClassDriver {

    public static void main(String args[]) {

        // create instance of nested Static class
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();

        // call non static method of nested static class
        printer.printMessage();

        // In order to create instance of Inner class we need an Outer class
        // instance. Let us create Outer class instance for creating
        // non-static nested class
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();

        // calling non-static method of Inner class
        inner.display();

        // we can also combine above steps in one step to create instance of
        // Inner class
        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

        // similarly we can now call Inner class method
        innerObject.display();
    }
}
