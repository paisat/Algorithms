package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * Implement an iterator to flatten a 2d vector.
 * For example,
 * Given 2d vector =
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * <p/>
 * Hint:
 * <p/>
 * How many variables do you need to keep track?
 * Two variables is all you need. Try with x and y.
 * Beware of empty rows. It could be the first few rows.
 * To write correct code, think about the invariant to maintain. What is it?
 * The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
 * Not sure? Think about how you would implement hasNext(). Which is more complex?
 * Common logic in two different places should be refactored into a common method.
 */
public class Flatten2DVector {


    Iterator<List<Integer>> listIterator;
    Iterator <Integer> integerIterator;

    public static void main(String []args){

        Flatten2DVector iterator=new Flatten2DVector(Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4),Arrays.asList(6,7,8)));

        print(iterator);


    }

    public static void print(Flatten2DVector iterator){

        System.out.println();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }

    public Flatten2DVector(List<List<Integer>> vector ){

        listIterator=vector.iterator();

    }

    public Integer next(){

        hasNext();
        Integer next=null;

        if(integerIterator!=null && integerIterator.hasNext() ){
            next=integerIterator.next();
        }

        return next;
    }

    public boolean hasNext(){

        // [ [] [3] ] . Loop required for empty list
        while ((integerIterator==null || !integerIterator.hasNext()) && listIterator.hasNext() ){
            integerIterator=listIterator.next().iterator();
        }

        return integerIterator!=null && integerIterator.hasNext();

    }

}
