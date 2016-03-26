package dynamicprogramming;

/**
 * Created by sarvothampai on 16/10/15.
 * <p/>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Time Complexity : O(N)
 *
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {


        if (prices != null && prices.length != 0) {

            if (prices.length == 1) {
                return 0;
            } else {

                int min = prices[0];
                //important dont miss
                int maxDiff = prices[1] - prices[0];


                for (int i = 1; i < prices.length; i++) {


                    if (prices[i] < min) {
                        min = prices[i];
                    }

                    if (prices[i] - min > maxDiff) {
                        maxDiff = prices[i] - min;
                    }


                }

                if (maxDiff > 0) {
                    return maxDiff;
                } else {
                    return 0;
                }


            }

        }

        return 0;

    }
}
