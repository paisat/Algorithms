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
 */

public class MidStack {

    public static void main(String[] args) {

        MidStack midStack = new MidStack();

        System.out.println(midStack.pop());
        System.out.println(midStack.getMid());
        midStack.add(2);
        midStack.printStack();
        System.out.println(midStack.getMid());
        midStack.add(3);
        midStack.printStack();
        System.out.println(midStack.getMid());
        midStack.add(4);
        midStack.printStack();
        System.out.println(midStack.getMid());
        System.out.println(midStack.pop());
        System.out.println(midStack.getMid());


    }


    private ListNode head;
    private ListNode mid;
    private int size;

    public MidStack() {
        head = null;
        mid = null;
        size = 0;
    }

    public void add(int val) {

        if (head == null) {
            head = new ListNode(val);
            size = 1;
            mid = head;
            return;
        }

        size = size + 1;

        ListNode element = new ListNode(val);
        element.setNext(head);
        head.setPrev(element);
        head = element;

        if (size % 2 == 0 && mid != null) {
            mid = mid.getPrev();
        }

    }

    public Integer pop() {

        if (head == null) {
            return null;
        }

        size--;


        if (size % 2 == 1) {
            mid = mid.getNext();
        }

        int element = head.getVal();

        head = head.getNext();

        return element;


    }

    public Integer getMid() {
        if (mid != null) {
            return mid.getVal();
        }

        return null;
    }

    public void printStack() {

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }

        System.out.println();

    }
}