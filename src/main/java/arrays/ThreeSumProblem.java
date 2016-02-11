package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sarvothampai on 24/09/15.
 * <p/>
 * Dont forget to Sort.
 *
 * O(N^2)
 *
 * Need not be contigious.
 */
public class ThreeSumProblem {


    public static void main(String[] args) {


        int a[] = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };

        ThreeSumProblem threeSumProblem = new ThreeSumProblem();


        List<List<Integer>> results;
        results = threeSumProblem.threeSum(a);

        for (List<Integer> integers : results) {
            System.out.println(integers);
        }


    }

    public List<List<Integer>> threeSum(int[] nums) {

        int target = 0;

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums != null && nums.length != 0) {

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {

                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {

                    if (nums[i] + nums[l] + nums[r] == target) {


                        List<Integer> sumPairs = new ArrayList<Integer>();
                        sumPairs.add(nums[i]);
                        sumPairs.add(nums[l]);
                        sumPairs.add(nums[r]);

                        if (!results.contains(sumPairs)) {
                            Collections.sort(sumPairs);
                            results.add(sumPairs);
                        }

                        l++;
                        r--;


                    } else if (nums[i] + nums[l] + nums[r] < target) {

                        l++;
                    } else {

                        r--;
                    }

                }

            }

        }


        return results;


    }
}


