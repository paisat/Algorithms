package arrays;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by sarvothampai on 29/01/16.
 *
 *
 * Time Complexity :
 *
 */
public class MergeStreams implements Iterator<Integer> {



    private  class Element{

        private int element;
        private IntStream stream;

        public Element(int element,IntStream stream){
            this.stream=stream;
            this.element=element;
        }


    }

    private PriorityQueue<Element> minHeap;

    public MergeStreams(IntStream ... streams ){

        minHeap=new PriorityQueue<Element>(10, new Comparator<Element>() {
            public int compare(Element o1, Element o2) {
                return o1.element-o2.element;
            }
        });

        for(IntStream stream :streams ){

            if(stream.hasNext()){
                minHeap.add(new Element( (Integer) stream.next(),stream));
            }
        }
    }


    public boolean hasNext() {
        return !minHeap.isEmpty();
    }

    public Integer next() {

        if(hasNext()){

            Element next=minHeap.poll();

            if(next.stream.hasNext()){
                minHeap.add(new Element((Integer) next.stream.next(),next.stream));
            }

            return next.element;

        }

        return null;
    }

    public void remove() {

    }


}
