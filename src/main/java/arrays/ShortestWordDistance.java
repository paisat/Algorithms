package arrays;

/**
 * Created by sarvothampai on 20/10/15.
 * <p/>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p/>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p/>
 * Given word1 = "coding", word2 = "practice", return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p/>
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 *
 * Time Complexity : O(N)
 *
 */
public class ShortestWordDistance {

    public static void main(String[] args) {

        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        String s1 = "makes";
        String s2 = "coding";


        ShortestWordDistance obj = new ShortestWordDistance();

        System.out.println(obj.shortestWordDistance(words, s1, s2));

    }

    public int shortestWordDistance(String[] words, String s1, String s2) {


        if (words != null && s1 != null && s2 != null) {


            int shortestDistance = Integer.MAX_VALUE;

            int i1 = -1;
            int i2 = -1;

            for (int i = 0; i < words.length; i++) {


                if (words[i].equals(s1)) {
                    i1 = i;
                }

                if (words[i].equals(s2)) {
                    i2 = i;
                }

                if (i1 != -1 && i2 != -1) {

                    shortestDistance = Math.min(shortestDistance, Math.abs(i1 - i2));
                }

            }

            return shortestDistance;

        }


        return -1;

    }
}
