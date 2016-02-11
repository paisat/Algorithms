package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 29/12/15.
 * <p/>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p/>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p/>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p/>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p/>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p/>
 * Time Complexity : O(N)
 *
 *
 * Intervals has to be sorted for this to work
 *
 */
public class InsertInterval {


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<Interval>();


        if (intervals != null && newInterval != null) {

            int i = 0;

            while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                i++;
            }


            while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
                newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
                i++;
            }

            result.add(newInterval);

            while (i < intervals.size()) {
                result.add(intervals.get(i));
                i++;
            }

        }

        return result;
    }

}
