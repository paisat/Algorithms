package javaquirks.nestedclasses.anonymousinnerclass;

/**
 * Created by sarvothampai on 15/01/16.
 */
public class AnonymousInnerclass {

    public abstract class Inner {
        public abstract void method();
    }

    public interface InnerInterface {
        public void method();
    }

    public void method() {

        Inner i = new Inner() {
            public void method() {
                System.out.println("inner method");
            }
        };

        i.method();


        InnerInterface a = new InnerInterface() {
            public void method() {
                System.out.println("method");
            }
        };

        a.method();


    }
}
