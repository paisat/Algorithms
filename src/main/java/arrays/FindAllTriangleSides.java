package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 28/12/15.
 * <p/>
 * <p/>
 * Given an unsorted array of positive integers.
 * Find the number of triangles that can be formed with three different array elements as three sides of triangles.
 * For a triangle to be possible from 3 values, the sum of any two values (or sides) must be greater than the third value (or third side).
 * For example, if the input array is {4, 6, 3, 7}, the output should be 3.
 * There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note that {3, 4, 7} is not a possible triangle.
 * As another example, consider the array {10, 21, 22, 100, 101, 200, 300}.
 * There can be 6 possible triangles: {10, 21, 22}, {21, 100, 101}, {22, 100, 101}, {10, 100, 101}, {100, 101, 200} and {101, 200, 300}
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(N^2)
 * <p/>
 * Why O(N^2) . J is not started from beginning
 *
 * Then for that i we must iterate j from i to n (it means O(n) operation) and internal while loop iterate k from i to n (it also means O(n) operation).
 * Note: I don't start while loop from the beginning for each j.
 * We also need to do it for each i from 0 to n. So it gives us n * (O(n) + O(n)) = O(n^2).
 *
 */
public class FindAllTriangleSides {

    public static void main(String[] args) {

        FindAllTriangleSides obj = new FindAllTriangleSides();

        System.out.println(obj.findAllPossibleTriangleSides(new int[] { 4, 6, 3, 7 }));
        System.out.println(obj.findAllPossibleTriangleSides(new int[] { 10, 21, 22, 100, 101, 200, 300 }));
        System.out.println(obj.findAllPossibleTriangleSides(new int[] { 10, 5, 3, 4, 7, 1 }));


    }


    public List<List<Integer>> findAllPossibleTriangleSides(int arr[]) {


        List<List<Integer>> triangleSides = new ArrayList<List<Integer>>();


        if (arr != null && arr.length >= 3) {

            int k = 0;

            Arrays.sort(arr);

            for (int i = 0; i < arr.length - 2; i++) {

                k = i + 2;


                for (int j = i + 1; j < arr.length; j++) {
                    while (k < arr.length && arr[i] + arr[j] > arr[k]) {
                        if (j != k) {
                            List<Integer> sides = new ArrayList<Integer>();
                            sides.add(arr[i]);
                            sides.add(arr[j]);
                            sides.add(arr[k]);
                            triangleSides.add(sides);
                        }

                        k++;
                    }

                    //if J becomes equal to k above loop is gonna increment it by 1
                    //hence -1
                    //total count will be k-j-1

                }

            }

        }


        return triangleSides;


    }
}
