package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 15/01/16.
 * <p/>
 * Time Complexity : O(N^2)
 */

public class DistinctPalindromicSubStrings {

    public static void main(String[] args) {

        DistinctPalindromicSubStrings obj = new DistinctPalindromicSubStrings();
        System.out.println(obj.distinctPalindromicSubstrings("abaaa"));
    }

    public Map<String, Integer> distinctPalindromicSubstrings(String s) {


        Map<String, Integer> result = new HashMap<String, Integer>();


        if (s != null || s.length() != 0) {

            result.put(s.charAt(0) + "", 1);


            for (int i = 1; i < s.length(); i++) {

                int low = i - 1;
                int high = i;

                String palindrome = "";

                result.put(s.charAt(i) + "", 1);

                while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                    palindrome = s.charAt(low) + palindrome + s.charAt(high);
                    low--;
                    high++;

                    if (result.containsKey(palindrome)) {
                        result.put(palindrome, result.get(palindrome) + 1);
                    } else {
                        result.put(palindrome, 1);
                    }

                }


                low = i - 1;
                high = i + 1;
                palindrome = s.charAt(i) + "";

                while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {

                    palindrome = s.charAt(low) + palindrome + s.charAt(high);
                    low--;
                    high++;

                    if (result.containsKey(palindrome)) {
                        result.put(palindrome, result.get(palindrome) + 1);
                    } else {
                        result.put(palindrome, 1);
                    }

                }


            }

        }


        return result;


    }
}
