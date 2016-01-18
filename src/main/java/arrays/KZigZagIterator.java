package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 24/12/15.
 *
 * ZigZag iterator for K list;
 *
 *
 */
public class KZigZagIterator {


    public static void main(String []args){

        KZigZagIterator iterator=new KZigZagIterator(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 7));
        print(iterator);
        iterator = new KZigZagIterator(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        print(iterator);
        iterator = new KZigZagIterator(Arrays.asList(1), Arrays.asList(2, 3));
        print(iterator);
        iterator = new KZigZagIterator(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6));
        print(iterator);

    }

    public static void print(KZigZagIterator iterator) {

        System.out.println();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }

    private LinkedList<Iterator<Integer>> iteratorList;

    public KZigZagIterator(List <Integer> ... lists ){

        if(lists!=null && lists.length!=0){

            iteratorList=new LinkedList<Iterator<Integer>>();

            for(List<Integer> l:lists){
                iteratorList.add(l.iterator());
            }
        }
    }


    public Integer next(){

        Integer next=null;

        if(hasNext()){

            Iterator<Integer> i=iteratorList.remove();
            next=i.next();
            if(i.hasNext()){
                iteratorList.add(i);
            }
        }

        return next;
    }


    public boolean hasNext(){
        return !iteratorList.isEmpty();
    }
}
