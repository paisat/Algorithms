package javaquirks.nestedclasses;

/**
 * Created by sarvothampai on 15/01/16.
 *
 *
 * Nested static class can only access static members of outer class
 * It doesnt need outerclass object to be instantiated.
 *
 *
 *
 *
 *
 */
public  class OuterClass {

    private static String msg = "GeeksForGeeks";

    // Static nested class
    public static class NestedStaticClass {

        // Only static members of Outer class is directly accessible in nested
        // static class
        public void printMessage() {

            // Try making 'message' a non-static variable, there will be
            // compiler error
            System.out.println("Message from nested static class: " + msg);
        }
    }

    // non-static nested class - also called Inner class
    public class InnerClass {

        // Both static and non-static members of Outer class are accessible in
        // this Inner class
        public void display() {
            System.out.println("Message from non-static nested class: " + msg);
        }
    }
}
