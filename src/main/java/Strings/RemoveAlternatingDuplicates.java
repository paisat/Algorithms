package Strings;

/**
 * Created by sarvothampai on 06/01/16.
 */
public class RemoveAlternatingDuplicates {

    public static void main(String[] args) {

        RemoveAlternatingDuplicates obj = new RemoveAlternatingDuplicates();
        System.out.println(obj.removeAlternateDuplicates("you got beautiful eyes"));

    }


    public String removeAlternateDuplicates(String s) {

        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int map[] = new int[256];

        int ptr = 0;
        map[s.charAt(0)] = 1;
        char charArray[] = s.toCharArray();

        for (int i = 1; i < charArray.length; i++) {

            char ch = s.charAt(i);

            if (map[ch] % 2 == 0) {
                ptr++;
                charArray[ptr] = ch;

            }
            map[ch]++;
        }


        String modified = new String(charArray);

        return modified.substring(0, ptr + 1);

    }

}
