package arrays;

/**
 * Created by sarvothampai on 16/10/15.
 * <p/>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p/>
 *
 *
 * Time Complexity : O(n)
 */
public class BestTimeToBuyAndSellStock2 {


    public int maxProfit(int[] prices) {


        int profit = 0;


        if (prices != null && prices.length != 0) {

            if (prices.length != 0) {

                int i = 0;
                int minima;
                int maxima;

                while (i < prices.length) {


                    while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                        i++;
                    }

                    //if the input keeps on increasing
                    if (i == prices.length - 1) {
                        return profit;
                    }

                    minima = prices[i];
                    i++;

                    while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                        i++;
                    }

                    maxima = prices[i];

                    profit += maxima - minima;

                    i++;

                }

            }

        }

        return profit;


    }

}
