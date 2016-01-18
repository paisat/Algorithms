package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sarvothampai on 14/11/15.
 * <p/>
 * <p/>
 * Step 1: Add next item to one of the heaps
 * <p/>
 * if next item is smaller than maxHeap root add it to maxHeap,
 * else add it to minHeap
 * <p/>
 * Step 2: Balance the heaps (after this step heaps will be either balanced or
 * one of them will contain 1 more item)
 * <p/>
 * if number of elements in one of the heaps is greater than the other by
 * more than 1, remove the root element from the one containing more elements and
 * add to the other one
 * Then at any given time you can calculate median like this:
 * <p/>
 * If the heaps contain equal elements;
 * median = (root of maxHeap + root of minHeap)/2
 * Else
 * median = root of the heap with more elements
 */
public class MedianOfStreamOfIntegers {


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    private Integer firstNumber;


    public static void main(String[] args) {
        MedianOfStreamOfIntegers obj = new MedianOfStreamOfIntegers();
    }

    public MedianOfStreamOfIntegers() {

        minHeap = new PriorityQueue<Integer>(20, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {

                return o1.compareTo(o2);
            }
        });

        maxHeap = new PriorityQueue<Integer>(30, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        firstNumber = null;

    }


    /*public int insert(int number){


        if(minHeap.isEmpty() && maxHeap.isEmpty() && firstNumber==null ){
            firstNumber=number;
        }
        else if(minHeap.isEmpty() && maxHeap.isEmpty() && firstNumber!=null ){

            if(number<firstNumber){

            }

        }



    }*/


}
