package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 19/12/15.
 * <p/>
 * Time Complexity : O(N)
 */
public class PrintLeadersInAnArray {


    public static void main(String[] args) {

        PrintLeadersInAnArray obj = new PrintLeadersInAnArray();
        int arr[] = { 16, 17, 4, 3, 5, 2 };

        System.out.println(obj.leadersInAnArray(arr));

    }


    public List<Integer> leadersInAnArray(int arr[]) {

        List<Integer> leaders = new ArrayList<Integer>();


        if (arr != null && arr.length != 0) {

            int max = Integer.MIN_VALUE;

            for (int i = arr.length - 1; i >= 0; i--) {

                if (arr[i] > max) {
                    leaders.add(arr[i]);
                    max = arr[i];
                }
            }

        }

        return leaders;


    }
}
