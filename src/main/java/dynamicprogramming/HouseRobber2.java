package dynamicprogramming;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * Note: This is an extension of House Robber.
 * <p/>
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {


    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));

    }

    private int robHelper(int[] nums, int start, int end) {

        int lastHouseRobbed = 0;
        int lastHouseNotRobbed = 0;

        for (int i = start; i <= end; i++) {

            int current = Math.max(lastHouseRobbed + nums[i], lastHouseNotRobbed);
            lastHouseRobbed = lastHouseNotRobbed;
            lastHouseNotRobbed = current;


        }

        return Math.max(lastHouseRobbed, lastHouseNotRobbed);

    }

}
