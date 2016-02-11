package arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 29/11/15.
 * <p/>
 * <p/>
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings  Skyline Contour
 The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
 It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

 For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 A key point is the left endpoint of a horizontal line segment.
 Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height.
 Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

 Notes:

 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 *
 *
 *
 * Time Complexity : O(N log n)
 */

//todo coplete this
public class SkylineProblem {

    public static void main(String []args){

        SkylineProblem obj=new SkylineProblem();

        int [][]buildings=new int[][]{{0,2,3},{2,5,3}};

        System.out.println(obj.getSkyline(buildings));



    }

    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0)
            return new LinkedList<int[]>();
        return recurSkyline(buildings, 0, buildings.length - 1);
    }

    public LinkedList<int[]> recurSkyline(int[][] buildings, int low, int high) {


        if (low<high) {
            int mid = low+(high - low) / 2;
            return merge(recurSkyline(buildings, low, mid), recurSkyline(buildings, mid+1, high));

        } else {

            int b1[] = { buildings[low][0], buildings[low][2] };
            int b2[] = { buildings[low][1], 0 };

            LinkedList<int[]> result = new LinkedList<int[]>();
            result.add(b1);
            result.add(b2);

            return result;

        }


    }


    public LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {


        LinkedList<int[]> result = new LinkedList<int[]>();
        int x;
        int h1 = 0, h2 = 0;
        int h;

        while (l1.size() != 0 && l2.size() != 0) {

            if (l1.getFirst()[0] < l2.getFirst()[0]) {

                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();

            } else if (l1.getFirst()[0] > l2.getFirst()[0]) {
                x = l2.getFirst()[0];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l2.removeFirst();
            } else {

                x = l2.getFirst()[0];
                h1 = l1.getFirst()[1];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();

            }

            if (result.size() == 0 || h != result.getLast()[1]) {
                result.add(new int[] { x, h });
            }

        }

        result.addAll(l1);
        result.addAll(l2);

        return result;

    }

}
