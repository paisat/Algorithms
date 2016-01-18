package heap;

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


public class MinHeap {

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        System.out.println("Enter number of elements");

        int length = in.nextInt();

        System.out.println("enter elements");

        ArrayList<Integer> elements =new ArrayList<Integer>();

        for(int i=0;i<length;i++){
            elements.add(in.nextInt());
        }


        MinHeap obj=new MinHeap();

        obj.minHeapify(elements);

        System.out.println("Min heap is : \n");

        for(Integer integer :elements){
            System.out.print(integer+" ");
        }


    }


    private void heapify(ArrayList<Integer> array, int pos) {

        int parent = pos;

        int leftChild = parent * 2 + 1;

        int rightChild = parent * 2 + 2;

        int lowestIndex = pos;


        if (leftChild <= array.size()-1) {

            if (array.get(leftChild) < array.get(lowestIndex)) {
                lowestIndex = leftChild;
            }

        }

        if (rightChild <= array.size()-1) {
            if (array.get(rightChild) < array.get(lowestIndex)) {

                lowestIndex = rightChild;
            }
        }

        if (lowestIndex != parent) {
            int temp = array.get(parent);
            array.set(parent,array.get(lowestIndex));
            array.set(lowestIndex,temp);
            heapify(array, lowestIndex);
        }

    }

    public void minHeapify(ArrayList<Integer> array) {

        int n = array.size();
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(array, i);

        }
    }

}


