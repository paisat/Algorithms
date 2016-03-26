package dynamicprogramming;

import java.util.LinkedList;

/**
 * Created by sarvothampai on 22/03/16.
 */
public class BestTimeToBuyAndSellStock4 {

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock4 obj = new BestTimeToBuyAndSellStock4();
        System.out.println(obj.maxProfit(2, new int[] { 3, 2, 6, 5, 0, 3 }));

    }


    /**
     * Time Complexity : O(KN)
     * Space Complexity : O(K)
     */
    public int maxProfit(int k, int[] prices) {

        /**
         *
         * First of all, we need to be clear of the definition of transaction.
         * The first question in this series clearly states that "...one transaction (ie, buy one and sell one share of the stock)".
         * Therefore, the whole period from buying to selling is considered one transaction, not two.
         * To avoid confusion, I'll define 'buying' and 'selling' as an 'Operation'.

         Secondly, when it says 'unlimited number of transaction', the number of possible transactions actually have nothing to do with the length of the array in theory.
         The problem does not prohibit buying and selling on the same day, nor does it say anything about how many operations you can do on one day.
         So technically, it is wrong to say that you can ONLY perform n/2 transaction; As a matter of fact, you can perform an infinite number of transaction (achievable by buying and selling multiple times on the same day).

         But doing that is pointless because we don't earn any money that way. So what really matters to us is the number of 'MEANINGFUL TRANSACTIONS' in which we actually earns money.
         That is to say, the transaction must include AT LEAST ONE RISING phase (Otherwise, we are losing money so we might as well not do the transaction at all). In an array of size N.
         There are at most N/2 rising phases. So we need at most k = N/2 transactions to cover all the rising phases.
         Therefore, if even more than N/2 transactions are allowed, we only need N/2 transactions to achieve the maximum profit.
         That's why we k is greater than N/2, we can effectively consider it to be "unlimited".
         *
         *
         * */

        if (k >= prices.length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }

        int[] maxProfit = new int[k + 1];
        int[] lowPrice = new int[k + 1];

        for (int i = 0; i < lowPrice.length; i++)
            lowPrice[i] = Integer.MAX_VALUE;

        for (int p : prices) {
            for (int i = 1; i <= k; i++) {
                lowPrice[i] = Math.min(p, p - maxProfit[i - 1]);
                maxProfit[i] = Math.max(maxProfit[i], p - lowPrice[i]);

            }
        }
        return maxProfit[k];
    }


    /**
     * Recurrence relation
     * <p/>
     * Max { T [i][j-1] | price[j] - price[m] + T [i-1][m] where m=0 to j   }
     * <p/>
     * i is number of transsactions and j is days;
     * <p/>
     * <p/>
     * Time Complexity : O(K*N)
     * Space Complexity : O(K*N)
     */

    public int maxProfit2(int k, int prices[]) {


        if (prices != null && prices.length >= 2) {


            if (k >= prices.length / 2) {

                int maxProfit = 0;

                for (int i = 1; i < prices.length; i++) {

                    if (prices[i] > prices[i - 1]) {
                        maxProfit += prices[i] - prices[i - 1];
                    }

                }

                return maxProfit;

            }


            int T[][] = new int[k + 1][prices.length];

            for (int i = 1; i <= k; i++) {

                int maxDiff = -prices[0];

                for (int j = 1; j < prices.length; j++) {

                    T[i][j] = Math.max(T[i][j - 1], maxDiff + prices[j]);
                    maxDiff = Math.max(maxDiff, T[i - 1][j - 1] - prices[j]);
                }

            }


            printActualSolution(T, prices);
            return T[k][prices.length - 1];

        }

        return 0;


    }

    private void printActualSolution(int T[][], int[] prices) {

        LinkedList<Integer> queue = new LinkedList<Integer>();

        int i = T.length - 1;
        int j = T[0].length - 1;


        while (true) {

            if (i == 0 || j == 0) {
                break;
            }

            if (T[i][j] == T[i][j - 1]) {
                j = j - 1;
            } else {

                int maxDiff = T[i][j] - prices[j];

                for (int k = j - 1; k >= 0; k--) {


                    if (T[i - 1][k] - prices[k] == maxDiff) {

                        i = i - 1;
                        j = k;

                        queue.addFirst(j);

                    }
                }

            }
        }


        while (!queue.isEmpty()) {
            System.out.println("Buy at price : " + prices[queue.pollFirst()]);
            System.out.println("Sell at price : " + prices[queue.pollFirst()]);


        }

    }
}
