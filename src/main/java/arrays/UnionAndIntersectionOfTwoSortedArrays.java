package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 17/10/15.
 * <p/>
 * <p/>
 * Time Complexity : O(m+n)
 */
public class UnionAndIntersectionOfTwoSortedArrays {


    public static void main(String[] args) {

        UnionAndIntersectionOfTwoSortedArrays obj = new UnionAndIntersectionOfTwoSortedArrays();

        int a1[] = { 3, 1, 4, 6 };
        int a2[] = { 1, 9, 0, 2, 1, 1, 6 };

        System.out.println(obj.unionOfTwoArrays(a1, a2));
        System.out.println(obj.intersectionOfTwoArrays(a1, a2));


    }

    public List<Integer> intersectionOfTwoArrays(int a1[], int a2[]) {

        List<Integer> inter = new ArrayList<Integer>();

        if (a1 != null && a2 != null && a1.length != 0 && a2.length != 0) {


            int m = a1.length;
            int n = a2.length;

            Arrays.sort(a1);
            Arrays.sort(a2);

            int i = 0, j = 0;

            Integer prev = null;

            while (i < m && j < n) {

                if (a1[i] < a2[j]) {
                    i++;
                } else if (a1[i] > a2[j]) {
                    j++;
                } else {
                    if (prev == null || prev != a1[i]) {
                        inter.add(a1[i]);
                        prev = a1[i];
                    }
                    i++;
                    j++;
                }


            }

        }

        return inter;

    }

    public List<Integer> unionOfTwoArrays(int[] a1, int[] a2) {

        List<Integer> union = new ArrayList<Integer>();


        if (a1 != null && a2 != null && a1.length != 0 && a2.length != 0) {

            Arrays.sort(a1);
            Arrays.sort(a2);

            int i = 0;
            int j = 0;

            int m = a1.length;
            int n = a2.length;

            Integer prev = null;

            while (i < m && j < n) {

                if (a1[i] < a2[j]) {

                    if ((prev == null || prev != a1[i])) {
                        union.add(a1[i]);
                        prev = a1[i];
                    }

                    i++;


                } else if (a1[i] > a2[j]) {

                    if (prev == null || prev != a2[j]) {
                        union.add(a2[j]);
                        prev = a2[j];
                    }
                    j++;


                } else {
                    if (prev == null || prev != a1[i]) {
                        union.add(a1[i]);
                        prev = a1[i];
                    }

                    i++;
                    j++;

                }

            }

            while (i < m) {
                if (prev == null || prev != a1[i]) {
                    union.add(a1[i]);
                    prev = a1[i];


                }
                i++;
            }

            while (j < n) {

                if (prev == null || prev != a2[j]) {
                    union.add(a2[j]);
                    prev = a2[j];


                }
                j++;
            }


        }

        return union;

    }


}
