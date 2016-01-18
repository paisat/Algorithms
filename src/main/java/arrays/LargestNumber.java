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
 */
public class LargestNumber {

    public static void main(String []args){

        int nums[]={3,30,34,5,9};

        LargestNumber obj=new LargestNumber();

        System.out.println(obj.largestNumber(nums));



    }

    public String largestNumber(int[] nums) {


        String result = null;

        if (nums != null && nums.length != 0) {

            String numsString[] = new String[nums.length];

            int i = 0;
            for (int num : nums) {
                numsString[i] = String.valueOf(num);
                i++;
            }


            // Example [121,12]
            Arrays.sort(numsString, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return (s2 + s1).compareTo(s1 + s2);
                }
            });

            if (numsString[0].equals("0")) {
                return "0";
            }

            result = "";

            for (int j = 0; j <numsString.length; j++) {
                result = result + numsString[j];
            }
        }

        return result;


    }
}
