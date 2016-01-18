package javaquirks.nestedinterface;

/**
 * Created by sarvothampai on 15/01/16.
 */
public class NestedInterfaceExample implements NestedInterface.message {

    public void message() {
        System.out.println("message method");
    }

    public static void main(String args[]) {
        NestedInterface.message messages = new NestedInterfaceExample();
        messages.message();
    }

}
