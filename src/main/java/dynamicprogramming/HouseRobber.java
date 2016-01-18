package dynamicprogramming;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p/>
 * Time Complexity : O(N)
 */
public class HouseRobber {


    public int rob(int[] nums) {

        Integer maxRob = 0;

        if (nums != null && nums.length != 0) {

            int lastHouseRobbed = 0;
            int lastHouseNotRobbed = 0;
            for (int i = 0; i < nums.length; i++) {

                int current = Math.max(nums[i] + lastHouseRobbed, lastHouseNotRobbed);
                lastHouseRobbed = lastHouseNotRobbed;
                lastHouseNotRobbed = current;

            }

            maxRob = Math.max(lastHouseRobbed, lastHouseNotRobbed);
        }

        return maxRob;

    }

}
