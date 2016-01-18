package javaquirks;

import arrays.ThreeSumClosest;

/**
 * Created by sarvothampai on 26/12/15.
 */
public class DeadLock {


    private class Resource1{

    }

    private class Resource2{

    }


    public static void main(String []args) throws Exception{

        DeadLock obj=new DeadLock();
        DeadLock.Thread1 t1 = obj.new Thread1();
        DeadLock.Thread2 t2=obj.new Thread2();

        Thread thread0=new Thread(t1);
        Thread thread1=new Thread(t2);

        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();


    }

    private class Thread1 implements Runnable{


        public void run() {

            System.out.println("Thread 1:  Waiting for Resource 1");
            synchronized (Resource1.class){

                System.out.println("Thread 1: Got lock of resource 1");

                try {
                    Thread.sleep(2000);
                }
                catch (Exception e){

                }

                System.out.println("Thread 1: Waiting for Resource 2");

                synchronized (Resource2.class){
                    System.out.println("Thread 1: Got lock of resource 2");
                }
            }

        }
    }

    private class Thread2 implements Runnable{

        public void run() {

            System.out.println("Thread 2: Waiting for Resource 2");
            synchronized (Resource2.class){

                System.out.println("Thread 2: Got lock of resource 2");

                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }

                System.out.println("Thread 2: Waiting for Resource 1");
                synchronized (Resource1.class){
                    System.out.println("Thread 2: Got lock of resource 1");
                }

            }

        }
    }

}
