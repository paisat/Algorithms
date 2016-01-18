package javaquirks;

/**
 * Created by sarvothampai on 22/10/15.
 */
public class AnonymousClassFromAbstract {



        public static void main(String args[]){
           Person p =new Person() {
               @Override
               void eat() {
                   System.out.println("eat");
               }
           };

            p.eat();

        }

}

abstract class Person{
    abstract void eat();
}
