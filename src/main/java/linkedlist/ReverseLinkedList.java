package linkedlist;

import java.util.LinkedList;

/**
 * Created by sarvothampai on 08/10/15.
 */
public class ReverseLinkedList {

    public static void main(String []args){


        ReverseLinkedList obj=new ReverseLinkedList();

        ListNode head=new ListNode(0);
        head.next=new ListNode(1);
        //head.next.next=new ListNode(2);

        ListNode newHead=obj.reverse(head,null);

        obj.print(newHead);




    }

    private void print(ListNode head){

        ListNode cur=head;

        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }

        System.out.println();

    }

    private ListNode reverse(ListNode head,ListNode prev){

        if(head==null){
            return prev;
        }

        ListNode next =head.next;
        head.next =prev;

        return reverse(next,head);


    }

}
