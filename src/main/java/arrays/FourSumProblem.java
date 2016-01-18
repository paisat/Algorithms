package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sarvothampai on 24/09/15.
 *
 * Should not contain any duplicates.
 * O(n^3) Complexity
 *
 */
public class FourSumProblem {

    public static void main(String args[]) {

        int a[] = {1, 0, -1, 0, -2, 2};
        int target = 0;

        FourSumProblem sumProblem = new FourSumProblem();

        List<List<Integer>> result = sumProblem.fourSum(a, target);

        for (List<Integer> integers : result) {

            System.out.println(integers);

        }


    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums != null && nums.length != 0) {

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {

                for (int j = i + 1; j < nums.length - 2; j++) {


                    int l = j + 1;
                    int r = nums.length - 1;

                    while (l < r) {

                        if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                            List<Integer> sum = new ArrayList<Integer>();
                            sum.add(nums[i]);
                            sum.add(nums[j]);
                            sum.add(nums[l]);
                            sum.add(nums[r]);

                            if (!result.contains(sum)) {
                                Collections.sort(sum);
                                result.add(sum);
                            }


                            l++;
                            r--;


                        } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }


                }
            }
        }

        return result;

    }

}
