package arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sarvothampai on 25/12/15.
 * <p/>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p/>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * <p/>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p/>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * O(n log N) finding the next transformation in a sequence.
    O(N) transformations per sequence
    O(26N/2) different sequences.

 O(26 ^ N/2 N log N).
 *
 * <p/>
 * <p/>
 * http://stackoverflow.com/questions/24596436/whats-time-complexity-of-this-algorithm-for-getting-all-word-ladders
 */
public class WordLadder {

    public static void main(String[] args) {

        WordLadder obj = new WordLadder();

        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dog");


        System.out.println(obj.ladderLength("hot", "dog", set));

    }


    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {


        int length = 2;

        if (beginWord != null
                && beginWord.length() != 0
                && endWord != null
                && endWord.length() != 0
                && wordList != null
                && wordList.size() != 0) {


            Queue<String> queue = new LinkedList<String>();


            queue.add(beginWord);


            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int j = 0; j < size; j++) {

                    String word = queue.poll();
                    wordList.remove(word);

                    for (int i = 0; i < word.length(); i++) {
                        StringBuilder sb = new StringBuilder(word);
                        for (int k = 0; k < 26; k++) {
                            sb.setCharAt(i, (char) ('a' + k));
                            String modWord = sb.toString();

                            if (modWord.equals(endWord)) {
                                return length;
                            }

                            if ((wordList.contains(modWord))) {
                                queue.add(modWord);
                            }

                        }

                    }


                }
                length++;


            }


        }
        return 0; //important . Length should only be returned if its found


    }


    /**
     *
     *
     * O(26^N/2 N log n)
     *
     * */

    public int ladderLengthBI(String beginWord, String endWord, Set<String> wordDict) {
        int len = 1;
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // add new words to smaller set to achieve better performance
            boolean isBeginSetSmall = beginSet.size() < endSet.size();
            Set<String> small = isBeginSetSmall ? beginSet : endSet;
            Set<String> big = isBeginSetSmall ? endSet : beginSet;
            Set<String> next = new HashSet<String>();
            len++;
            for (String str : small) {
                // construct all possible words
                for (int i = 0; i < str.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        StringBuilder sb = new StringBuilder(str);
                        sb.setCharAt(i, ch);
                        String word = sb.toString();
                        if (big.contains(word)) {
                            return len;
                        }
                        if (wordDict.contains(word) && !visited.contains(word)) {
                            visited.add(word);
                            next.add(word);
                        }
                    }
                }
            }
            if (isBeginSetSmall) {
                beginSet = next;
            } else {
                endSet = next;
            }
        }
        return 0;
    }

}
