package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sarvothampai on 23/10/15.
 * <p>
 * <p>
 * Time Complexity : O(N log k)
 * <p>
 * N is the total number of elements in all lists.
 */
public class MergeKSortedLists {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        ListNode[] listNodes = new ListNode[1];
        listNodes[0] = node1;

    }

    public ListNode mergeKLists(ListNode[] lists) {


        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;


        if (lists != null && lists.length != 0) {


            PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {

                public int compare(ListNode o1, ListNode o2) {

                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val > o2.val) {
                        return 1;
                    } else {
                        return 0;
                    }

                }

            });


            int length = lists.length;


            for (int i = 0; i < length; i++) {

                ListNode head = lists[i];

                if (head != null) {

                    minHeap.add(head);
                }


            }


            while (!minHeap.isEmpty()) {

                ListNode head = minHeap.poll();

                p.next = head;

                if (head.next != null) {
                    minHeap.add(head.next);
                }

                p = p.next;

            }


        }


        return fakeHead.next;


    }
}
