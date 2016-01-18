package arrays;

/**
 * Created by sarvothampai on 13/11/15.
 * <p/>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * <p/>
 * Note: You may not slant the container.
 * <p/>
 * Time Complexity : O(N)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = 0;


        if (height != null && height.length != 0) {

            int left = 0;
            int right = height.length - 1;

            while (left < right) {

                int h = Math.min(height[left], height[right]);

                int area = (right - left) * h;
                maxArea = Math.max(maxArea, area);

                while (left < right && height[left] <= h) {
                    left++;
                }

                while (left < right && height[right] <= h) {
                    right--;
                }


            }

        }


        return maxArea;

    }
}
