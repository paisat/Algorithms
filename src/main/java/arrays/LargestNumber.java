package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p/>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p/>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * //TODO Google
 *
 * Time Complexity : O(n log n)
 *
 */
public class LargestNumber {

    public static void main(String[] args) {

        Integer nums[] = { 3, 30, 34, 5, 9 };
        Integer nums2[]={9,918,917};
        Integer nums3[]={1,112,113};

        LargestNumber obj = new LargestNumber();

        System.out.println(obj.largestNumber(nums));
        System.out.println(obj.largestNumber(nums2));
        System.out.println(obj.largestNumber(nums3));


    }

    public String largestNumber(Integer[] nums) {


        String result = null;

        if (nums != null && nums.length != 0) {

            // Example [121,12]
            Arrays.sort(nums, new Comparator<Integer>() {
                public int compare(Integer s1, Integer s2) {
                    return (s2.toString() + s1.toString() ).compareTo(s1.toString() + s2.toString() );
                }
            });

            if (nums[0] == 0) {
                return "0";
            }

            result = "";

            for (int j = 0; j < nums.length; j++) {
                result = result + nums[j];
            }
        }

        return result;


    }
}
