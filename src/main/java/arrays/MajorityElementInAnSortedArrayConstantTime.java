package arrays;

import java.util.Arrays;

/**
 * Created by sarvothampai on 12/03/16.
 *
 *
 * Given a sorted array of size N of int32, find an element that repeats > ceil(N / 2) times.
 * Your algo may assume that there will be always such element. Space/time O(1).
 Follow up question: Now element repeats > ceil(N / 4) times. Space/time O(1)

 //todo GOOGLE
 *
 */
public class MajorityElementInAnSortedArrayConstantTime {






    public int getMajorityElement(int arr[]){
        Arrays.sort(arr);
        return arr[(arr.length/2)-1];
    }
}
