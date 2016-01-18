package javaquirks;

/**
 * Created by sarvothampai on 06/10/15.
 */
public class Truck implements Kitchen {
    Kitchen kitchen =new KitchenImpl();


    public void cook() {
        kitchen.cook();
    }
}
