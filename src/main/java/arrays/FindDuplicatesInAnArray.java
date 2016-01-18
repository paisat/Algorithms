package arrays;

import java.util.ArrayList;
import java.util.List;

// @formatter off

/**
 * Created by sarvothampai on 11/11/15.
 * <p/>
 * Given an array of n elements which contains elements from 0 to n-1,
 * <p/>
 * with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
 * <p/>
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 *
 * Time Complexity : O(n)
 */
public class FindDuplicatesInAnArray {


    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };

        FindDuplicatesInAnArray obj = new FindDuplicatesInAnArray();

        System.out.println(obj.getDuplicates(arr));

    }


    public List<Integer> getDuplicates(int arr[]) {


        List<Integer> result = new ArrayList<Integer>();

        if (arr != null && arr.length != 0) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[Math.abs(arr[i])] > 0) {
                    arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
                } else {
                    result.add(Math.abs(arr[i]));
                }


            }

        }

        return result;


    }

}
