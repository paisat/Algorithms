package Threads;

/**
 * Created by sarvothampai on 27/12/15.
 */
public class PoolThread extends Thread {


    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public PoolThread(BlockingQueue queue) {
        taskQueue = queue;
    }

    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = (Runnable) taskQueue.dequeue();
                runnable.run();
            } catch (Exception e) {
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }


    public synchronized boolean isStopped() {
        return isStopped;
    }

}
