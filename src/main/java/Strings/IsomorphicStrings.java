package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarvothampai on 10/12/15.
 * <p/>
 * <p/>
 * <p/>
 * Given two strings s and t, determine if they are isomorphic.
 * <p/>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p/>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p/>
 * For example,
 * Given "egg", "add", return true.
 * <p/>
 * Given "foo", "bar", return false.
 * <p/>
 * Given "paper", "title", return true.
 * <p/>
 * Note
 * Two empty strings are also isomorphic.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */


public class IsomorphicStrings {


    /**
     * Time Complexity O(N^2)
     */
    public boolean isIsomorphic(String s, String t) {


        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {

            char s1 = s.charAt(i);
            char s2 = t.charAt(i);


            if (!charMap.containsKey(s1)) {

                if (charMap.containsValue(s2)) {
                    return false;
                }

                charMap.put(s1, s2);
            } else {
                if (s2 != charMap.get(s1)) {
                    return false;
                }
            }

        }

        return true;

    }


    /**
     * Time Complexity : O(N)
     * <p>
     * Cant handle unicode characters
     * Assumes character are ascii.
     */
    public boolean isIsomorphic2(String s, String t) {


        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int m1[] = new int[256];
        int m2[] = new int[256];

        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (m1[ch1] != m2[ch2]) {
                return false;
            }

            m1[ch1] = i;
            m2[ch2] = i;


        }

        return true;


    }

}
