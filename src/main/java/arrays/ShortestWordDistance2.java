package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p/>
 * Time Complexity : O(M+N)
 */
public class ShortestWordDistance2 {

    public static void main(String[] args) {

        ShortestWordDistance2 obj = new ShortestWordDistance2();

        String words[] = { "practice", "makes", "perfect", "coding", "makes" };

        System.out.println(obj.shortestWordDistance(new String[] { "a", "b" }, "a", "b"));

    }

    Map<String, List<Integer>> map;

    public ShortestWordDistance2() {

    }

    public ShortestWordDistance2(String[] words) {

        fill(words);

    }

    private void fill(String[] words) {

        map = new HashMap<String, List<Integer>>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (map.containsKey(word)) {
                map.get(word).add(i);
            } else {
                List<Integer> index = new ArrayList<Integer>();
                index.add(i);
                map.put(word, index);

            }

        }

    }

    public int shortest(String word1, String word2) {

        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);

        int i = 0;
        int j = 0;
        int distance = Integer.MAX_VALUE;

        while (i < index1.size() && j < index2.size()) {

            int i1 = index1.get(i);
            int i2 = index2.get(j);

            if (i1 < i2) {
                distance = Math.min(distance, i2 - i1);
                i++;

            } else {
                distance = Math.min(distance, i1 - i2);
                j++;
            }

        }

        return distance;

    }

    public int shortestWordDistance(String[] words, String s1, String s2) {

        if ((words == null || words.length == 0) || (s1 == null || s1.length() == 0) || (s2 == null || s2.length() == 0)) {
            return Integer.MAX_VALUE;
        }

        Integer minDistance = Integer.MAX_VALUE;
        int prev = -1;
        int i = 0;

        for (i = 0; i < words.length; i++) {

            if (words[i].equals(s1) || words[i].equals(s2)) {
                prev = i;
                break;
            }

        }

        i++;

        if (prev != -1) {

            for (; i < words.length; i++) {


                if (words[i].equals(s1) || words[i].equals(s2)) {


                    if (!words[prev].equals(words[i]) && i - prev < minDistance) {
                        minDistance = i - prev;
                        prev = i;
                    } else {
                        prev = i;
                    }

                }

            }
        }


        return minDistance;

    }
}
