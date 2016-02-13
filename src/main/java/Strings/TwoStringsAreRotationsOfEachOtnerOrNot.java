package Strings;

/**
 * Created by sarvothampai on 11/11/15.
 * <p/>
 * <p/>
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1 using only one call to strstr routine?
 * (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
public class TwoStringsAreRotationsOfEachOtnerOrNot {


    public static void main(String[] args) {

        TwoStringsAreRotationsOfEachOtnerOrNot obj = new TwoStringsAreRotationsOfEachOtnerOrNot();

        String str1 = "ABACD";
        String str2 = "CDABA";
        System.out.println(obj.isRotatedString(str1, str2));

        String s1 = "ABCD", s2 = "ACBD";

        System.out.println(obj.isRotatedString(s1, s2));

    }

    public boolean isRotatedString(String s1, String s2) {


        if ((s1 == null || s1.length() == 0) || (s2 == null || s2.length() == 0)) {
            return false;
        }

        String s = s1 + s1;

        return s.contains(s2);

    }

}
