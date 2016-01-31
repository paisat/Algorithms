package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sarvothampai on 13/01/16.
 * <p/>
 * <p/>
 * <p/>
 * Given a list of tuples representing intervals, return the range these intervals
 * covered.
 * e.g:
 * [(1,3), (2,5),(8,9)] should return 5
 * <p/>
 * Time Complexity : O(N log N)
 */

public class FindRange {


    public static void main(String[] args) {

        FindRange obj = new FindRange();
        System.out.println(obj.findRange(Arrays.asList(new Interval(1, 3), new Interval(2, 5), new Interval(8, 10), new Interval(4, 9))));
        System.out.println(obj.findRange(Arrays.asList(new Interval(1, 3), new Interval(4, 5), new Interval(7, 10))));
        System.out.println(obj.findRange(Arrays.asList(new Interval(3, 6), new Interval(8, 9), new Interval(1, 5))));

        Long l = 1000000007L;

    }


    public int findRange(List<Interval> list) {

        if (list == null || list.size() == 0) {
            return 0;
        }

        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        Iterator<Interval> intervalIterator = list.iterator();

        int lower_bound = intervalIterator.next().start;
        int upper_boudn = intervalIterator.next().end;

        int result = upper_boudn - lower_bound;


        while (intervalIterator.hasNext()) {

            Interval i = intervalIterator.next();

            if (i.start < upper_boudn) {

                if (i.end < upper_boudn) {
                    continue;
                } else {

                    result += i.end - upper_boudn;
                    upper_boudn = i.end;

                }


            } else {

                lower_bound = i.start;
                upper_boudn = i.end;

                result += upper_boudn - lower_bound;

            }

        }

        return result;
    }

//    int getTotalCoveredLength() {
//        if (intervals.isEmpty()) {
//            return 0;
//        }
//
//        Collections.sort(intervals, new IntervalComparator());
//
//        int len = 0;
//
//        Interval prev = intervals.get(0);
//
//        for (int i = 1; i < intervals.size(); i++) {
//            Interval curr = intervals.get(i);
//
//            if (overlaps(prev, curr)) {
//                prev.start = prev.start;
//                prev.end = Math.max(prev.end, curr.end);
//            } else {
//                len += prev.end - prev.start;
//                prev = curr;
//            }
//        }
//
//        len += prev.end - prev.start; // Be very careful to check this case.
//
//        return len;
//    }

//    private boolean overlaps(Interval prev, Interval curr) {
//        return prev.end > curr.start;
//    }

}