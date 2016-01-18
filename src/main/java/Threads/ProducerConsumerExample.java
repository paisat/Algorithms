package Threads;

/**
 * Created by sarvothampai on 22/10/15.
 */


public class ProducerConsumerExample {
    public static void main(String[] args)  {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}