package Strings;

import java.util.HashMap;

/**
 * Created by sarvothampai on 10/12/15.
 * <p/>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p/>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p/>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * <p/>
 * Time Complexity : O(N)
 */
public class WordPattern {


    public boolean wordPattern(String pattern, String str) {


        if (pattern == null || str == null) {
            return false;
        }


        pattern = pattern.trim();
        str = str.trim();

        String[] words = str.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();

        for (int i = 0; i < pattern.length(); i++) {

            char key = pattern.charAt(i);
            if (!map.containsKey(key)) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(key, words[i]);
            } else {
                if (!map.get(key).equals(words[i])) {
                    return false;
                }
            }
        }

        return true;

    }

}
