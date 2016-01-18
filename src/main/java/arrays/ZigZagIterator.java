package arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 22/12/15.
 * <p/>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 *
 *
 */
public class ZigZagIterator {


    public static void main(String[] args) {

        ZigZagIterator iterator = new ZigZagIterator(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 7));
        print(iterator);
        iterator = new ZigZagIterator(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        print(iterator);
        iterator = new ZigZagIterator(Arrays.asList(1), Arrays.asList(2, 3));
        print(iterator);
        iterator = new ZigZagIterator(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6));
        print(iterator);
    }


    public static void print(ZigZagIterator iterator) {

        System.out.println();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }


    private List<Integer> l1;
    private List<Integer> l2;
    private int listID;
    private int counter1;
    private int counter2;

    public ZigZagIterator(List<Integer> l1, List<Integer> l2) {

        this.l1 = l1;
        this.l2 = l2;
        listID = 1;
        counter1 = 0;
        counter2 = 0;
    }

    public Integer next() {


        if (hasNext()) {


            if (counter1 > l1.size() - 1 && counter2 < l2.size() - 1) {
                return l2.get(counter2++);
            } else if (counter2 > l2.size() - 1 && counter1 < l1.size() - 1) {
                return l1.get(counter1++);
            } else {

                if (listID == 1) {

                    listID = 2;
                    return l1.get(counter1++);
                } else {
                    listID = 1;
                    return l2.get(counter2++);
                }

            }


        }

        return null;

    }

    public boolean hasNext() {

        return (counter1 < l1.size() || counter2 < l2.size());
    }
}
