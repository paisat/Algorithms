package javaquirks;

/**
 * Created by sarvothampai on 24/09/15.
 */
public abstract class Process {

//    private Process(){
//
//        System.out.println("Abstract class constructor");
//
//    }
    protected void runProcess(){
        cleanProcess();
        processData();


    }

    public abstract void processData();

    public void cleanProcess(){

    }
}
