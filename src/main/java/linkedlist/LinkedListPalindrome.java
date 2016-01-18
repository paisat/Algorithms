package linkedlist;

import tree.TreeNode;

/**
 * Created by sarvothampai on 09/10/15.
 */


public class LinkedListPalindrome {

    public static void main(String[] args) {

        LinkedListPalindrome obj = new LinkedListPalindrome();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next =new ListNode(2);
        head.next.next.next =new ListNode(1);
       // head.next.next = new ListNode(1);
        System.out.println(obj.isPalindromeRecursive(head));
        System.out.println(obj.isPalindrome(head));


    }


    public boolean isPalindromeRecursive(ListNode head){

        return isPalindromeHelper(head,new ListNode[]{head});

    }

    private boolean isPalindromeHelper(ListNode back,ListNode[] front  ){

        if(back==null){
            return true;
        }

        boolean result=isPalindromeHelper(back.next,front);

        if(!result){
            return false;
        }

        result = (front[0]!=null && back.val==front[0].val);

        front[0]=front[0].next;

        return result;

    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        if (head != null) {

            if (head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null) {
                fast = fast.next;

                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }


            ListNode mid = slow;

            ListNode l2 = mid.next;
            ListNode l1 =head;
            mid.next = null;

            l2= reverse(l2);

            while (l1!=null && l2!=null){
                if(l1.val!=l2.val){
                    return false;
                }

                l1=l1.next;
                l2=l2.next;
            }

            mid.next = reverse(l2);

            return true;


        }

        return false;

    }


    private ListNode reverse(ListNode head){

        if(head==null){
            return null;
        }

        ListNode cur=head;
        ListNode prev=null;

        while (cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;

            cur=next;
        }

        return prev;

    }


}
