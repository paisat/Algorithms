package linkedlist;

import java.util.Arrays;

/**
 * Created by sarvothampai on 08/10/15.
 */
public class CycleInALinkedList {

    public boolean hasCycle(ListNode head) {

        if(head==null){
            return false;
        }

        ListNode slow=head;
        ListNode fast=head;

        while(slow !=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow!=null && fast!=null && slow==fast){
                return true;
            }

        }

        return false;

    }
}
