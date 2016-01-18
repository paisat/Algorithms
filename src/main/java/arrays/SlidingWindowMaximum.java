package arrays;

import java.util.LinkedList;

/**
 * Created by sarvothampai on 17/12/15.
 * <p/>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p/>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p/>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p/>
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * Space Complexity : O(K)
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        SlidingWindowMaximum obj = new SlidingWindowMaximum();

        int nums[] = { 1, 3, 1, 2, 0, 5 };
        int k = 3;

        int result[] = obj.maxSlidingWindow(nums, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }


    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = {};

        if (nums != null && nums.length != 0 && k > 0) {


            result = new int[nums.length - k + 1];

            int index = 0;

            LinkedList<Integer> queue = new LinkedList<Integer>();

            for (int i = 0; i < Math.min(k, nums.length); i++) {

                while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                    queue.removeLast();
                }

                queue.addLast(i);
            }


            for (int i = k; i < nums.length; i++) {

                result[index] = nums[queue.getFirst()];
                index++;

                while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                    queue.removeLast();
                }

                while (!queue.isEmpty() && queue.getFirst() <= i - k) {
                    queue.removeFirst();
                }

                queue.addLast(i);

            }

            result[index] = nums[queue.getFirst()];

        }

        return result;

    }


}
