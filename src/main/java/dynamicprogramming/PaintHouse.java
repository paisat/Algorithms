package dynamicprogramming;

/**
 * Created by sarvothampai on 25/12/15.
 * <p/>
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p/>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Find the minimum cost to paint all houses.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {

        int minCost = 0;


        if (costs != null && costs.length != 0) {

            int n = costs.length;

            int r = 0, b = 0, g = 0;

            for (int i = 0; i < n; i++) {

                int rr = r, bb = b, gg = g;

                r = costs[i][0] + Math.min(bb, gg);
                b = costs[i][1] + Math.min(rr, gg);
                g = costs[i][2] + Math.min(rr, bb);

            }

            minCost = Math.min(r, Math.min(b, g));

        }
        return minCost;

    }


}
