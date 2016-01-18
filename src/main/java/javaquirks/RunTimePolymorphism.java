package javaquirks;

/**
 * Created by sarvothampai on 12/11/15.
 */
public class RunTimePolymorphism {


    public static void main(String []args){

        Base base = new RunTimePolymorphism().new Derived();

        base.baseMethod();
        System.out.println(base.baseVariable);



    }


    private class Base{

        public Base(int i){

        }

        public int baseVariable=45;

        public void baseMethod(){
            System.out.println("Base method");
        }

    }

    private class Derived extends Base{


        public Derived(){
            super(2);
        }

        public int baseVariable = 34;

        public void someMethod(){
            System.out.println("test");
        }


        public void baseMethod(){
            System.out.println("Derived method");
        }

    }


}


