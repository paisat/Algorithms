package Strings;

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
}
