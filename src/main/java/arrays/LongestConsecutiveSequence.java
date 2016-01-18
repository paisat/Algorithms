package arrays;

import java.util.HashSet;

/**
 * Created by sarvothampai on 20/10/15.
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if (nums != null && nums.length != 0) {

            HashSet<Integer> set = new HashSet<Integer>();

            int answer = 1;

            for (int i = 0; i < nums.length; i++) {

                set.add(nums[i]);

            }


            for (int i = 0; i < nums.length; i++) {

                if (!set.contains(nums[i] - 1)) {

                    int j = nums[i];

                    while (set.contains(j)) {
                        j++;
                    }

                    if (answer < j - nums[i]) {
                        answer = j - nums[i];
                    }

                }

            }

            return answer;
        }

        return -1;
    }
}
