package ds;

/**
 * Created by sarvothampai on 08/01/16.
 */
public class CircularQueue {


    private int size;
    private int head;
    private int tail;
    private int q[];

    public CircularQueue(int s) {
        size = s;
        q = new int[s];
        head = -1;
        tail = -1;
    }



    public synchronized boolean enqueue(int v) {
        int pos = (tail + 1) % size;
        if (pos == head) return false;
        if (head == -1) {
            head = 0;
        }
        q[pos] = v;
        tail = pos;
        return true;
    }

    public synchronized int dequeue() throws Exception {
        if (head == -1 || tail == -1) throw new Exception("queue underflow!");

        int tmp = q[head];

        if(head==tail){
            head=-1;
            tail=-1;
        }
        else {

            head = (head + 1) % size;
        }
        return tmp;
    }
}