package linkedlist;

import java.util.Scanner;

/**
 * Created by sarvothampai on 16/09/15.
 */
public class AddTwoLinkedLists {


    public static void main(String args[]) {


        AddTwoLinkedLists obj = new AddTwoLinkedLists();
        ListNode list1 = obj.readLinkedList();
        ListNode list2 = obj.readLinkedList();


        ListNode result=obj.addTwoNumbers(list1, list2);

        ListNode resultCur=result;

        System.out.println();
        while(resultCur!=null){
            System.out.print(resultCur.getVal());
            resultCur=resultCur.getNext();
        }





    }


    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode result=null;
        ListNode curResult=null;

        int carry =0;


        while (cur1 != null || cur2 != null) {

            int val1=(cur1==null)?0:cur1.getVal();
            int val2=(cur2==null)?0:cur2.getVal();

            int sum = val1+val2+carry;

            carry=(sum>=10)?1:0;

            if(result==null){
                result =new ListNode(sum%10);
                curResult=result;
            }
            else{
                curResult.setNext(new ListNode(sum%10));
                curResult=curResult.getNext();
            }

            if(cur1!=null) {
                cur1 = cur1.getNext();
            }

            if(cur2!=null) {
                cur2 = cur2.getNext();
            }

        }

        if(carry==1){
            curResult.setNext(new ListNode(carry));
        }


        return result;

    }

    private ListNode readLinkedList() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter first List Number of elments");

        int n1 = in.nextInt();

        System.out.println("enter list elements");

        ListNode head1 = null, head2 = null;
        ListNode cur1 = null;

        for (int i = 0; i < n1; i++) {

            if (head1 == null) {
                head1 = new ListNode(in.nextInt());
                cur1 = head1;
            } else {
                cur1.setNext(new ListNode(in.nextInt()));
                cur1 = cur1.getNext();
            }

        }

        return head1;
    }

}
