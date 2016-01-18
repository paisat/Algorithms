package arrays;

/**
 * Created by sarvothampai on 01/01/16.
 *
 * On a screen, there are multiple rectangles drawn, when a user clicks on any point,
 *
 * find the smallest rectangle enclosing this point.
 *
 *
 * for a rectangle in a list of rectangles
 if ((x > x1 && x < x2) && (y > y1 && y < y2))
 temp_area = (x2 - x1) * (y2 - y1);
 if (temp_area < area)
 area = temp_area;

 iterate through rectangles enclosing this point .
 Find smallest area among those.
 *
 */
public class RectangleWithMinimumAreaEnclosingAPoint {
}
