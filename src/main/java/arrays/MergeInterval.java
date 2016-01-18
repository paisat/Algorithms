package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sarvothampai on 25/12/15.
 * <p/>
 * <p/>
 * <p/>
 * Can also be used to find conflicting appointments.
 * <p/>
 * Time Complexity : O(N log N)
 */
public class MergeInterval {


    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<Interval>();

        if (intervals != null && intervals.size() != 0) {
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start;
                }
            });
            Interval prev = null;

            for (Interval i : intervals) {

                if (prev == null || i.start > prev.end) {
                    result.add(i);
                    prev = i;
                } else if (i.end > prev.end) {
                    prev.end = i.end;
                }

            }
        }

        return result;


    }


}
