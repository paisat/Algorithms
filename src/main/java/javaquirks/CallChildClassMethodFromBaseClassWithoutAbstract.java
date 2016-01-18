package javaquirks;

/**
 * Created by sarvothampai on 24/09/15.
 *
 *
 *
 */
 class Base {


    protected int variable;

    public Base() {
        System.out.println("base constructor");
    }


    public Base(int l){

    }
    public void foo() {
        doStuff();
    }

    public void doStuff() {
        System.out.println("base");
    }

    public void doStuff2(){

    }

    public static void main(String []args){
        Base b=new Derived();
        b.doStuff();


    }

}

class Derived extends Base {

    public static void main(String []args){

        Base b=new Derived();
        b.doStuff();
    }

//    public Derived() {
//        System.out.println("derived constructor");
//
//    }

    public void doStuff2(){

    }

    @Override
    public void doStuff() {
        System.out.println("derived");
    }
}