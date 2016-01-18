package tree;

/**
 * Created by sarvothampai on 15/10/15.
 */
public class ListNode {

    int val;
    ListNode next;

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
