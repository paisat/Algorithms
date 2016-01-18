package Threads;

import java.io.IOException;

/**
 * Created by sarvothampai on 22/10/15.
 */


public class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized String take()  {
        // Wait until message is
        // available.
        while (empty) {
            try {
                System.out.println(empty);
                wait();
                System.out.println("wait over");
                System.out.println(empty);
            } catch (InterruptedException e) {
            }
        }

        System.out.println("wait over 2");
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(String message) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                System.out.println(empty + " sa");
                wait();
                System.out.println("wait over");
                System.out.println(empty);
            } catch (InterruptedException e) {
            }
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drop)) return false;

        Drop drop = (Drop) o;

        if (empty != drop.empty) return false;
        return !(message != null ? !message.equals(drop.message) : drop.message != null);

    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (empty ? 1 : 0);
        return result;
    }
}
