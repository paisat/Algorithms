package Strings;

/**
 * Created by sarvothampai on 17/09/15.
 *
 * Time Complexity : O(N)
 *
 */
public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {


        LongestSubstringWithoutRepeatingChar obj = new LongestSubstringWithoutRepeatingChar();
        System.out.println(obj.lengthOfLongestSubstring("abba"));

    }

    private int lengthOfLongestSubstring(String s) {

        int visited[] = new int[256];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        int cur_length = 0;
        int max_length = 0;


        if (s != null && s.length() != 0) {

            visited[s.charAt(0)] = 0;
            cur_length = 1;


            for (int i = 1; i < s.length(); i++) {

                char c = s.charAt(i);

                if (visited[c] == -1 || i - cur_length > visited[c]) {
                    cur_length++;
                } else {

                    if (cur_length > max_length) {
                        max_length = cur_length;
                    }

                    cur_length = i - visited[c];
                }

                visited[c] = i;


            }
        }

        return (cur_length > max_length) ? cur_length : max_length;

    }


}
