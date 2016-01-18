package javaquirks;

/**
 * Created by sarvothampai on 26/12/15.
 */
public class Threads {


    public static void main(String[] args) throws Exception {

        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        Thread thread = new Thread(new MyThread());
        thread.start();

        System.out.println("main 2");

    }

}


class MyThread implements Runnable {


    public void run() {
        Thread t = Thread.currentThread();

        try {

            wait(2000);
        } catch (Exception e) {

        }

        System.out.println("thread , " + t.getName());

    }
}