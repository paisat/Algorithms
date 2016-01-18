package arrays;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * his is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * <p/>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p/>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p/>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p/>
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 * Time Complexity : O(N)
 *
 */
public class ShortestWordDistance3 {

    public static void main(String[] args) {

        ShortestWordDistance3 obj = new ShortestWordDistance3();

        System.out.println(obj.shortestWordDistance(new String[] { "a", "a", "b", "b" }, "a", "b"));
        System.out.println(obj.shortestWordDistance(new String[] { "a", "a", "b", "b" }, "a", "c"));


    }

    public Integer shortestWordDistance(String[] words, String s1, String s2) {

        boolean same = s1.equals(s2);

        long distance = Integer.MAX_VALUE, i1 = distance, i2 = -distance;

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(s1)) {

                if (same) {
                    i2 = i1;
                    i1 = i;

                } else {
                    i1 = i;
                }

            } else if (words[i].equals(s2)) {
                i2 = i;
            }

            distance = Math.min(distance, Math.abs(i1 - i2));

        }

        if(i1==Integer.MAX_VALUE || i2==-Integer.MAX_VALUE){
            return null;
        }

        return (int) distance;


    }
}
