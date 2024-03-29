package arrays;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * Following is a simpler approach. Two rectangles do not overlap if one of the following conditions is true.
 * 1) One rectangle is above top edge of other rectangle.
 * 2) One rectangle is on left side of left edge of other rectangle.
 * <p/>
 * We need to check above cases to find out if given rectangles overlap or not. Following is C++ implementation of the above approach.
 * <p/>
 * #include<stdio.h>
 * <p/>
 * struct Point
 * {
 * int x, y;
 * };
 * <p/>
 * // Returns true if two rectangles (l1, r1) and (l2, r2) overlap
 * bool doOverlap(Point l1, Point r1, Point l2, Point r2)
 * {
 * // If one rectangle is on left side of other
 * if (l1.x > r2.x || l2.x > r1.x)
 * return false;
 * <p/>
 * // If one rectangle is above other
 * if (l1.y < r2.y || l2.y < r1.y)
 * return false;
 * <p/>
 * return true;
 * }
 * <p/>
 * int main()
 * {
 * Point l1 = {0, 10}, r1 = {10, 0};
 * Point l2 = {5, 5}, r2 = {15, 0};
 * if (doOverlap(l1, r1, l2, r2))
 * printf("Rectangles Overlap");
 * else
 * printf("Rectangles Don't Overlap");
 * return 0;
 * }
 */


public class CheckIfTwoTrianglesIntersect {
}
