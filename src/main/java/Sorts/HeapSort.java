package Sorts;

import heap.MaxHeap;
import heap.MinHeap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sarvothampai on 24/09/15.
 */
public class HeapSort {

    public static void main(String []args){

        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of elements");

        int length = in.nextInt();

        ArrayList<Integer> arrayList =new ArrayList<Integer>();

        System.out.println("Enter elements :");

        for(int i=0;i<length;i++){
            arrayList.add(in.nextInt());
        }

        HeapSort heapSort=new HeapSort();
        heapSort.sort(arrayList);

        System.out.println("Sorted elements \n");

        for(Integer integer :arrayList ){
            System.out.println(integer + " ");
        }

    }


    public void sort(ArrayList<Integer> integers){

        MaxHeap heap=new MaxHeap();
        heap.maxHeapify(integers);

        int length = integers.size();

        while(length!=0){


            int max = integers.get(0);
            int last = integers.get(length-1);

            integers.set(length-1,max);
            integers.set(0,last);

            length--;

            heap.heapify(integers,0,length);

        }



    }

}
