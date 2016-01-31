package ds;

/**
 * Created by sarvothampai on 29/01/16.
 */
public class CircularQueueDriver {

    public static void main(String[] args) throws Exception {

        CircularQueue queue = new CircularQueue(3);

        try {
            queue.dequeue();
        } catch (Exception e) {
            System.out.println("queue underflow");
        }

        queue.enqueue(2);
        System.out.println(queue.dequeue());

        try {
            queue.dequeue();
        } catch (Exception e) {
            System.out.println("queue underflow");
        }


        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.enqueue(4));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        try {
            queue.dequeue();

        } catch (Exception e) {

            System.out.println("queue underflow");
        }


    }
}
