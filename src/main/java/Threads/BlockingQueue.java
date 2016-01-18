package Threads;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 27/12/15.
 * <p/>
 * "Invoking wait inside a synchronized method is a simple way to acquire the intrinsic lock"
 * <p/>
 * This sentence is false, it is an error in documentation.
 * <p/>
 * Thread acquires the intrinsic lock when it enters a synchronized method. Thread inside the synchronized method is set as the owner of the lock and is in RUNNABLE state. Any thread that attempts to enter the locked method becomes BLOCKED.
 * <p/>
 * When thread calls wait it releases the current object lock (it keeps all locks from other objects) and than goes to WAITING state.
 * <p/>
 * When some other thread calls notify or notifyAll on that same object the first thread changes state from WAITING to BLOCKED, Notified thread does NOT automatically reacquire the lock or become RUNNABLE, in fact it must fight for the lock with all other blocked threads.
 * <p/>
 * WAITING and BLOCKED states both prevent thread from running, but they are very different.
 * <p/>
 * WAITING threads must be explicitly transformed to BLOCKED threads by a notify from some other thread.
 * <p/>
 * WAITING never goes directly to RUNNABLE.
 * <p/>
 * When RUNNABLE thread releases the lock (by leaving monitor or by waiting) one of BLOCKED threads automatically takes its place.
 * <p/>
 * So to summarize, thread acquires the lock when it enters synchronized method or when it reenters the synchronized method after the wait.
 * <p/>
 * public synchronized guardedJoy() {
 * // must get lock before entering here
 * while(!joy) {
 * try {
 * wait(); // releases lock here
 * // must regain the lock to reentering here
 * } catch (InterruptedException e) {}
 * }
 * System.out.println("Joy and efficiency have been achieved!");
 * }
 * shareimprove this answer
 */


public class BlockingQueue<E> {

    private List<E> queue = new LinkedList<E>();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }


    public synchronized void enqueue(E item)
            throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized E dequeue()
            throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }

}

