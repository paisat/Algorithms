package arrays;

import java.util.HashMap;
import java.util.Map;

///
//  Created by sarvothampai on 17/01/16.
// /
public class MaxPointsOnALine {


    public static void main(String[] args) {

        MaxPointsOnALine obj = new MaxPointsOnALine();
        obj.maxPoints(new Point[] { new Point(0, 0), new Point(-1, -1), new Point(2, 2) });
    }

    public int maxPoints(Point[] points) {


        if (points == null || points.length == 0) {
            return 0;
        }


        Map<Integer, Map<Integer, Integer>> slopeCountMap = new HashMap<Integer, Map<Integer, Integer>>();

        int result = 0;

        for (int i = 0; i < points.length; i++) {

            slopeCountMap.clear();
            int max = 0;
            int overlap = 0;
            int vertical = 0;

            Point p1 = points[i];

            for (int j = i + 1; j < points.length; j++) {

                Point p2 = points[j];

                if (p1.x == p2.x && p1.y == p2.y) {
                    overlap++;


                } else if (p1.x == p2.x) {
                    vertical++;
                } else {

                    int y = p2.y - p1.y;
                    int x = p2.x - p1.x;

                    int gcd = gcd(x, y);

                    if (gcd != 0) {
                        x = x / gcd;
                        y = y / gcd;
                    }


                    if (slopeCountMap.get(x)!=null ) {

                        if(slopeCountMap.get(x).get(y)!=null){
                            slopeCountMap.get(x).put(y,slopeCountMap.get(x).get(y)+1);
                        }
                        else {
                            slopeCountMap.get(x).put(y,1);
                        }

                    } else {

                        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                        map.put(y, 1);
                        slopeCountMap.put(x, map);
                    }

                    max = Math.max(max, slopeCountMap.get(x).get(y));

                }
            }


            result = Math.max(result, overlap + max + 1);

        }


        return result;


    }

    private int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }

}
