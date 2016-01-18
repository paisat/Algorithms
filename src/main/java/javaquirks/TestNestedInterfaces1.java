package javaquirks;

/**
 * Created by sarvothampai on 22/10/15.
 */
public class TestNestedInterfaces1 implements Showable.Message {


    public void msg() {
        System.out.println("Hello nested interface");
    }

    public static void main(String args[]) {

        Showable.Message message=new Showable.Message(){

            public void msg(){

            }
        };

    }


}


interface Showable {
    void show();

    interface Message {
        void msg();
    }
}
