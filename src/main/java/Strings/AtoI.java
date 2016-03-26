package Strings;

/**
 * Created by sarvothampai on 30/09/15.
 */
public class AtoI {


    public static void main(String args[]) {

        AtoI atoI = new AtoI();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(atoI.myAtoi("-2147483648"));
    }

    public int myAtoi(String str) {

        if (str == null) return 0;
        int i = 0;
        boolean sign = true;
        str = str.trim();
        int n = str.length();
        if (i < n && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            if (str.charAt(0) == '+') sign = true;
            else sign = false;
            ++i;
        }
        int res = 0;

        while (i < n && Character.isDigit(str.charAt(i))) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + str.charAt(i) - 48;
            ++i;
        }
        return sign ? res : -res;
    }

}



