package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 19/10/15.
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.

    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<String>();

        if (nums != null && nums.length != 0) {

            if (nums.length == 1) {
                result.add(String.valueOf(nums[0]));
                return result;
            }

            int beg = 0;
            int end = 0;

            for (int i = 0; i < nums.length; i++) {

                beg = i;
                end = i;
                while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                    end = i + 1;
                    i++;
                }

                if (nums[beg] == nums[end]) {
                    result.add(nums[beg] + "");
                } else {
                    result.add(nums[beg] + "->" + nums[end]);
                }

            }

        }

        return result;

    }
}
