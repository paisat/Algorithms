package javaquirks.nestedinterface;

/**
 * Created by sarvothampai on 15/01/16.
 * <p/>
 * Nested interface must be public if it is declared inside the interface but it can have any access modifier if declared within the class.
 * Nested interfaces are declared static implicitely.
 *
 * Interface variables are static and final by default;
 *
 */
public interface NestedInterface {

    Integer i=345;

    interface message {
        public void message();
    }

}
