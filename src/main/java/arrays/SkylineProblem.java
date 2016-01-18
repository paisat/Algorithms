package arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sarvothampai on 29/11/15.
 * <p/>
 * <p/>
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
