package javaquirks;

/**
 * Created by sarvothampai on 22/10/15.
 */
public class AnonymousClassFromInheritance {


    public static void main(String args[]) {
        Eatable e = new Eatable() {
            public void eat() {
                System.out.println("nice fruits");
            }
        };
        e.eat();
    }

}

interface Eatable {
    void eat();
}
