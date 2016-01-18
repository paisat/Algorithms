package linkedlist;

/**
 * Created by sarvothampai on 25/10/15.
 */
public class ReverseADoublyLinkedList {
    
    
    //// TODO: 25/10/15 Complete this . Need to test 
    
    public static void main(String []args){
        
        
        
    }
        
    public ListNode reverse(ListNode head) {

        if (head == null) {
            return head;
        }


        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {

            next = cur.next;
            cur.next = prev;
            cur.prev = next;
            prev = cur;
            cur = next;

        }

        return (prev != null) ? prev : head;
    }
}
