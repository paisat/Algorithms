package Strings;

import java.util.Arrays;

/**
 * Created by sarvothampai on 10/12/15.
 * <p/>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p/>
 * <p/>
 * Assign prime numbers to each character . Find product of all characters . If products are same
 * then its an anagram
 *
 * Count number of characters in each word
 * both char counts should be same.
 *
 * <p/>
 * <p/>
 * <p/>
 * Time Complexity : O(n)
 */
public class ValidAnagram {

    public static void main(String[] args) {

        ValidAnagram obj = new ValidAnagram();

        System.out.println(obj.isAnagram("ab", "ba"));

    }

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        char sChar[] = s.toCharArray();
        char tChar[] = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);


        s = new String(sChar);
        t = new String(tChar);


        return s.equals(t);

    }
}
