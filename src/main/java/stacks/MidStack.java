package stacks;

import linkedlist.ListNode;

/**
 * Created by sarvothampai on 17/01/16.
 * <p>
 * Time Complexity :
 * <p>
 * Push : O(1)
 * Pop : O(1)
 * getMiddle : O(1)
 *
 */

public class MidStack {

    ListNode head;
    ListNode middle;
    int size = 0;

    public void push(int val) {
        size++;
        if (head == null) {
            head = new ListNode(val);
            middle = head;
        } else {
            ListNode node = new ListNode(val);
            node.setNext(head);
            head.setPrev(node);
            head = node;
            if (size % 2 == 0) {
                middle = middle.getPrev();
            }
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        size--;
        int ret;
        ret = head.getVal();
        if (size == 0) {
            head = null;
            middle = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
            if (size % 2 == 1) {
                middle = middle.getNext();
            }
        }
        return ret;
    }

    public Integer findMiddle() {
        if (middle != null) {
            return middle.getVal();
        }

        return null;
    }


    public void deleteMiddle() {
        size--;
        if (middle.getPrev() != null) {
            middle.getPrev().setNext(middle.getNext());
        }
        if (middle.getNext() != null) {
            middle.getNext().setPrev(middle.getPrev());
        }
        if (size % 2 == 1) {
            middle = middle.getNext();
        } else {
            middle = middle.getPrev();
        }
    }
}