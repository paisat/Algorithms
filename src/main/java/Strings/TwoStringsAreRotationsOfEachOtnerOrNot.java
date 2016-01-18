package Strings;

/**
 * Created by sarvothampai on 11/11/15.
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
