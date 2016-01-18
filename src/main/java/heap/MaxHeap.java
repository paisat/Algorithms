package heap;

//import javaquirks.Base;

import javaquirks.TestClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sarvothampai on 22/09/15.
 *
 * Creating heap complexity O(n)
 * Extract min O(logn)
 *
 *
 */


public class MaxHeap {

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        System.out.println("Enter number of elements");

        int length = in.nextInt();

        System.out.println("enter elements");

        ArrayList<Integer> elements =new ArrayList<Integer>();

        for(int i=0;i<length;i++){
            elements.add(in.nextInt());
        }


        MaxHeap obj=new MaxHeap();

        obj.maxHeapify(elements);

        System.out.println("Max heap is : \n");

        for(Integer integer :elements){
            System.out.print(integer+" ");
        }


    }


    public void heapify(ArrayList<Integer> array, int pos , int length) {

        int parent = pos;

        int leftChild = parent * 2 + 1;

        int rightChild = parent * 2 + 2;

        int highestIndex = pos;


        if (leftChild <= length-1) {

            if (array.get(leftChild) > array.get(highestIndex)) {
                highestIndex = leftChild;
            }

        }

        if (rightChild <= length-1) {
            if (array.get(rightChild) > array.get(highestIndex)) {

                highestIndex = rightChild;
            }
        }

        if (highestIndex != parent) {
            int temp = array.get(parent);
            array.set(parent,array.get(highestIndex));
            array.set(highestIndex,temp);
            heapify(array, highestIndex ,length);
        }

    }

    public void maxHeapify(ArrayList<Integer> array) {

        int n = array.size();
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(array, i ,array.size());

        }
    }

}


