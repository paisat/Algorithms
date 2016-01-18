package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by sarvothampai on 06/01/16.
 */

public class SubtractNumbersUsingLinkedList
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Create Linked Lists */
        LinkedList<Integer> num1 = new LinkedList<Integer>();
        LinkedList<Integer> num2 = new LinkedList<Integer>();
        LinkedList<Integer> ans = new LinkedList<Integer>();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        /* Accept numbers */
        System.out.println("Subtracting Large Numbers Using Linked Lists Test\n");
        System.out.println("Enter number 1");
        String str1 = scan.next();
        System.out.println("Enter number 2");
        String str2 = scan.next();



        /* Find larger number */
        int l1 = str1.length(), l2 = str2.length();
        String s1 = str1, s2 = str2;
        boolean sign = false;
        if (l1 < l2 || (l1 == l2 && str1.compareTo(str2) < 0))
        {
            s1 = str2;
            s2 = str1;
            sign = true;
        }
        l1 = s1.length();
        while (s2.length() != l1)
            s2 = "0" + s2;
        /* Store digits in lists */
        for (int i = l1 - 1; i >= 0; i--)
        {
            num1.add(s1.charAt(i) - '0');
            /* 9 complement of second number */
            num2.add('9' - s2.charAt(i));
        }
        /* Add the numbers */
        int carry = 0;
        for (int i = 0; i < l1; i++)
        {
            int d1 = 0, d2 = 0;
            try {
                d1 = num1.get(i);
            }
            catch(Exception e){}
            try {
                d2 = num2.get(i);
            }
            catch(Exception e){}
            int x = d1 + d2 + carry;
            tmp.add(x % 10);
            carry = x / 10;
        }
        /* Adding carry and storing in ans list*/
        for (int i = 0; i < l1; i++)
        {
            int x = tmp.get(i) + carry;
            ans.add(x % 10);
            carry = x / 10;
        }
        /* Print number */
        System.out.print("\nDifference = ");
        if (s1.equals(s2))
            System.out.print("0\n");
        else
        {
            if (sign)
                System.out.print("-");
            /* Dont print leading zeroes */
            int i;
            for (i = ans.size() - 1; i >= 0; i--)
                if (ans.get(i) != 0)
                    break;
            for (; i >= 0; i--)
                System.out.print(ans.get(i));
            System.out.println();
        }
    }
}