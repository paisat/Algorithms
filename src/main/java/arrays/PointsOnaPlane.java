package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sarvothampai on 13/01/16.
 *
 * Time Complexity : O(n) + O(n-k  * Log k )
 *
 */
public class PointsOnaPlane {


    public static void main(String []args){

        PointsOnaPlane obj=new PointsOnaPlane();

    }

    public List<Point> findKNearestPoints(List<Point> points, Point original, int k) {
        List<Point> result = new ArrayList<Point>();

        if (points == null || points.size() == 0 || original == null || k <= 0) {
            return result;
        }

        PriorityQueue<Point> pq = new PriorityQueue<Point>(k);

        for (Point point : points) {
            if (pq.size() < k) {
                pq.offer(point);
            } else {
                if (pq.peek().compareTo(point) > 0) {
                    pq.poll();
                    pq.offer(point);
                }
            }
        }

        result.addAll(pq);
        return result;
    }

    class Point implements Comparable<Point> {
        int x, y;
        double distance;

        public Point (int x, int y, Point original) {
            this.x= x;
            this.y = y;

            // sqrt(x^2 + y^2)
            distance = Math.hypot(x - original.x, y - original.y);
        }


        public int compareTo(Point that) {
            return Double.compare(this.distance,that.distance);
        }
    }
}
