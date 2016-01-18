package arrays;

import java.util.List;

/**
 * Created by sarvothampai on 13/11/15.
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Time Complexity : O(n^2)
 *
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int result=0;


        if(triangle!=null && triangle.size()!=0){

            int size =triangle.size();

            int dp[] =new int[triangle.get(size-1).size()];

            for(int i=0;i<dp.length;i++){
                dp[i]=triangle.get(size-1).get(i);
            }

            for(int i=size-2;i>=0;i--){
                for(int j=0;j<triangle.get(i).size();j++){
                    dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
                }

            }

            result=dp[0];

        }

        return result;


    }
}
