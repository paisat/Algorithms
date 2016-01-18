package javaquirks.nestedinterface;

/**
 * Created by sarvothampai on 15/01/16.
 */
public class NestedInterfaceWithinAClassExample implements NestedInterfaceWithinAClass.NestedInterface {

    public void message(){
        System.out.println("test");
    }

    public static void main(String []args){

        NestedInterfaceWithinAClass.NestedInterface obj=new NestedInterfaceWithinAClassExample();
        obj.message();

    }


}
