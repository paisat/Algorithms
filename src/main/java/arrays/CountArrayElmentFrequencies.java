package arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sarvothampai on 30/12/15.
 * <p/>
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * Given an unsorted array of n integers which can contain integers from 1 to n.
 * Some elements can be repeated multiple times and some other elements can be absent from the array.
 * Count frequency of all elements that are present and print the missing elements.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
public class CountArrayElmentFrequencies {


    public static void main(String[] args) {

        CountArrayElmentFrequencies obj = new CountArrayElmentFrequencies();

        System.out.println(obj.frequencies(new int[] { 2, 3, 3, 2, 5 }));
        System.out.println(obj.frequencies(new int[] { 4, 4, 4, 4 }));


    }


    public Map<Integer, Integer> frequencies(int arr[]) {


        Map<Integer, Integer> frequencies = new TreeMap<Integer, Integer>();


        if (arr != null && arr.length != 0) {

            int i = 0;

            while (i < arr.length) {

                if (arr[i] <= 0) {
                    i++;
                    continue;
                }

                int elementIndex = arr[i] - 1;

                if (arr[elementIndex] > 0) {
                    arr[i] = arr[elementIndex];
                    arr[elementIndex] = -1;
                } else {
                    arr[elementIndex]--;
                    arr[i] = 0;
                    i++;
                }

            }

            for (i = 0; i < arr.length; i++) {
                frequencies.put(i + 1, Math.abs(arr[i]));
            }

        }

        return frequencies;

    }

}
