package javaquirks;

/**
 * Created by sarvothampai on 24/09/15.
 */
public  class MyProcess extends Process {


    private int a;




    public MyProcess(int a){

        this.a=a;


    }


    @Override
    public void processData() {

        System.out.println("my process process data");

    }


    public static void main(String []args){


        int a[]={2,3,4};





        Object object=new Object();
        System.out.println(object.hashCode());

        MyProcess process =new MyProcess(2);
        MyProcess process1 =new MyProcess(2);
        System.out.println(process.equals(process1));

        process.runProcess();
    }
}

