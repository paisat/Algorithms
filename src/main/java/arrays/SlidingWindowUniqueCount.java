package arrays;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k.
 * <p/>
 * Example:
 * <p/>
 * Input:  arr[] = {1, 2, 1, 3, 4, 2, 3};
 * k = 4
 * Output:
 * 3
 * 4
 * 4
 * 3
 * <p/>
 * Explanation:
 * First window is {1, 2, 1, 3}, count of distinct numbers is 3
 * Second window is {2, 1, 3, 4} count of distinct numbers is 4
 * Third window is {1, 3, 4, 2} count of distinct numbers is 4
 * Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */

public class SlidingWindowUniqueCount {


    public static void main(String[] args) {

        SlidingWindowUniqueCount obj = new SlidingWindowUniqueCount();
        System.out.println(obj.countDistinctInSlidingWindow(new int[] { 1, 2, 1, 3, 4, 2, 3 }, 4));
    }

    public List<Integer> countDistinctInSlidingWindow(int arr[], int k) {


        List<Integer> result = new ArrayList<Integer>();


        if (arr != null && arr.length != 0 && k > 0) {


            Map<Integer, Integer> distinctElementCount = new HashMap<Integer, Integer>();
            int countDistinct = 0;

            for (int i = 0; i < k && i < arr.length; i++) {


                if (distinctElementCount.containsKey(arr[i])) {
                    distinctElementCount.put(arr[i], distinctElementCount.get(arr[i]) + 1);
                } else {
                    countDistinct++;
                    distinctElementCount.put(arr[i], 1);
                }

            }

            result.add(countDistinct);

            for (int i = k; i < arr.length; i++) {

                if (distinctElementCount.get(arr[i - k]) == 1) {
                    countDistinct--;
                    distinctElementCount.remove(arr[i - k]);
                } else {
                    distinctElementCount.put(arr[i - k], distinctElementCount.get(arr[i - k]) - 1);
                }

                if (distinctElementCount.containsKey(arr[i])) {
                    distinctElementCount.put(arr[i], distinctElementCount.get(arr[i]) + 1);
                } else {
                    countDistinct++;
                    distinctElementCount.put(arr[i], 1);
                }

                result.add(countDistinct);


            }


        }

        return result;


    }


}
