package arrays;

import dynamicprogramming.StringInterleaving;
import java.util.Arrays;

/**
 * Created by sarvothampai on 08/01/16.
 */
public class MinSumAbsolute {

    public static int findMinAbsSum(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;

        int min[] = new int[3];

        int mn = Integer.MAX_VALUE;

        while (i < a.length && j < b.length && k < c.length) {
            int sm = Math.abs(a[i] - b[j]) + Math.abs(b[j] - c[k]) + Math.abs(c[k] - a[i]);
            if (sm < mn) {
                mn = sm;
                min[0] = a[i];
                min[1] = b[j];
                min[2] = c[k];
            }


            int local_mn = a[i];
            if (local_mn > b[j]) {
                local_mn = b[j];
            }
            if (local_mn > c[k]) {
                local_mn=c[k];
            }

            if(local_mn==a[i]) {
                i++;
            }

            else if(local_mn==b[j]){
                j++;
            }

            else if(local_mn==c[k]){
                k++;
            }
        }

        return mn;

    }


    public static void  main(String []args) {
        int a[] = { 90, 83, 16, 28, 45, 35, 63, 71, 3 };
        int b[] = { 95, 88, 19, 26, 48, 37, 69, 72, 1 };
        int c[] = { 91, 85, 15, 29, 43, 33, 66, 74, 2 };

        int min = findMinAbsSum(a, b, c);

        System.out.println(min);
    }
}
