package Strings;

/**
 * Created by sarvothampai on 01/01/16.
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class RunLengthEncoding {


    public static void main(String[] args) {

        RunLengthEncoding obj = new RunLengthEncoding();
        //System.out.println(obj.runLengthEncoding("wwwwaaadexxxxxx"));
        System.out.println(obj.runLengthEncoding("abcdef"));


    }

    public String runLengthEncoding(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }


        StringBuilder result = new StringBuilder();


        int length = 1;
        for (int i = 0; i < s.length() && result.length() < s.length(); i++) {

            result.append(s.charAt(i));
            if (result.length() >= s.length()) {
                break;
            }
            char prev = s.charAt(i);
            length = 1;

            while (i + 1 < s.length() && s.charAt(i + 1) == prev) {
                i++;
                length++;

            }

            result.append(length);

        }

        return result.toString();

    }
}
