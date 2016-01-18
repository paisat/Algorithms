package arrays;

/**
 * Created by sarvothampai on 26/10/15.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p/>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock
 *
 * Time Complexity : O(n)
 *
 */
public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        //highest profit in 0 ... i
        int[] profit = new int[prices.length];

        // DP from left to right
        profit[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit[i] = Math.max(profit[i - 1], prices[i] - min);
        }

        // DP from right to left

        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            profit[i] = Math.max(profit[i + 1], profit[i]+max - prices[i]);
        }


        return profit[0];
    }
}
