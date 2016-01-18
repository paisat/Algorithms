package arrays;

import java.util.Stack;

/**
 * Created by sarvothampai on 29/11/15.
 * <p/>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * <p/>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p/>
 * Time Complexity : O(n);
 */

//todo complete this. Two solutions . 1) Divide and Conquer 2) O(n) using stacks.

public class LargestAreaInAHistogram {

    public static void main(String []args){

        LargestAreaInAHistogram obj=new LargestAreaInAHistogram();
        obj.largestRectangleArea(new int[]{1,2,2});

    }


    public int largestRectangleArea(int[] height) {


        if (height != null && height.length != 0) {

            Stack<Integer> stack = new Stack<Integer>();

            int maxArea = 0;

            int i;

            for (i = 0; i < height.length; ) {

                if (stack.isEmpty() || (height[i] >= height[stack.peek()])) {
                    stack.add(i++);
                } else {

                    int top = stack.pop();

                    if (stack.isEmpty()) {
                        maxArea = Math.max(maxArea, height[top] * i);
                    } else {
                        maxArea = Math.max(maxArea, height[top] * (i - stack.peek() - 1));
                    }

                }
            }

            while (!stack.isEmpty()) {

                int top = stack.pop();

                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, height[top] * i);
                } else {
                    maxArea = Math.max(maxArea, height[top] * (i - stack.peek() - 1));
                }


            }

            return maxArea;

        }

        return 0;

    }
}
