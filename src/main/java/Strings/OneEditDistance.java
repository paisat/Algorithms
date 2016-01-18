package Strings;

/**
 * Created by sarvothampai on 11/11/15.
 * <p/>
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {

    public static void main(String[] args) {

        OneEditDistance obj = new OneEditDistance();

        System.out.println(obj.isOneEditDistance("a", ""));
        System.out.println(obj.isOneEditDistance("", "b"));
        System.out.println(obj.isOneEditDistance("", ""));
        System.out.println(obj.isOneEditDistance("abc", "abc"));
        System.out.println(obj.isOneEditDistance("abcd", "abce"));
        System.out.println(obj.isOneEditDistance("a", "daddadad"));
        System.out.println(obj.isOneEditDistance("abbb", "a"));
        System.out.println(obj.isOneEditDistance("a", "daddadad"));
        System.out.println(obj.isOneEditDistance("abcd", "abc"));

    }


    public boolean isOneEditDistance(String a, String b) {


        if ((a == null || a.length() == 0) && (b == null || b.length() == 0)) {

            return false;

        }

        if (a == null || a.length() == 0) {
            return b.length() == 1;
        }

        if (b == null || b.length() == 0) {
            return a.length() == 1;
        }

        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }

        int i = 0, j = 0;
        int count = 0;

        while (i < a.length() && j < b.length()) {

            if (a.charAt(i) != b.charAt(j)) {
                count++;

                if (count > 1) {
                    return false;
                }

                if (a.length() > b.length()) {
                    i++;
                } else if (a.length() < b.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }


            } else {
                i++;
                j++;
            }

        }

        if (i < a.length() || j < b.length()) {
            count++;
        }

        return count == 1;


    }

}
