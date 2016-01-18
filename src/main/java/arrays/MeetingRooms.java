package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sarvothampai on 25/12/15.
 * <p/>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p/>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {

        if (intervals == null) {
            return false;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }

        }

        return true;


    }

}
