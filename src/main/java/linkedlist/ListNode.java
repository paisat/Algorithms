package linkedlist;

/**
 * Created by sarvothampai on 16/09/15.
 */
public class ListNode {

     int val;
     ListNode next;

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    ListNode prev;

    public ListNode(int x){
        this.val=x;
        next=null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
