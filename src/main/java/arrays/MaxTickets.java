package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sarvothampai on 30/01/16.
 * <p>
 * There are n ticket windows in the railway station. The with window has a(j) tickets available. The price of a ticket is equal to the number of tickets remaining in that window at that time. What is the maximum amount of money the railway station can earn from selling the first m tickets?
 * <p>
 * For example if we got 3 ticket windows, have tickets of 3, 3, 4, and we want to sell 5 tickets. Then:
 * <p>
 * n = 3, m = 5
 * A[3] = {3, 3, 4}
 * The maximum money earned is 4 + 3 + 3 + 3 + 2 = 15
 * <p>
 * Time Complexity : n Log M
 */
public class MaxTickets {

    public static void main(String[] args) {

        MaxTickets obj = new MaxTickets();

        System.out.println(obj.maxPrice(new int[] { 2, 5 }, 4));
        System.out.println(obj.maxPrice(new int[] { 3, 3, 4 }, 5));


    }

    public int maxPrice(int tickets[], int n) {

        Integer ammount = 0;

        if (tickets != null && tickets.length != 0 && n > 0) {

            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int ticket : tickets) {
                maxHeap.add(ticket);
            }

            for (int i = 1; i <= n; i++) {

                int ticket = maxHeap.poll();
                ammount += ticket;

                if (ticket > 1) {
                    maxHeap.add(ticket - 1);
                }

            }

        }

        return ammount;


    }
}
