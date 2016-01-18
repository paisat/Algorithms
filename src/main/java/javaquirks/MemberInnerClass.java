package javaquirks;

/**
 * Created by sarvothampai on 26/12/15.
 *
 * Member inner class cannot exist without outer class.
 * Member inner class can access all functions of outer class.
 * Even private
 *
 *
 */
public class MemberInnerClass {


    public static void main(String args[]){

        MemberInnerClass obj=new MemberInnerClass();
        MemberInnerClass.Inner objInner= obj.new Inner();

        objInner.print();

    }

    private int a=1;

    private void function1(){
        System.out.println("Outer Private Function");

    }

    public class Inner{

        public void print(){
            System.out.println("a "+a);
            function1();
        }

    }

}
