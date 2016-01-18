package Strings;

/**
 * Created by sarvothampai on 21/10/15.
 */
public class AddBinary {

    public static void main(String[] args) {

        AddBinary obj = new AddBinary();

        System.out.println(obj.addBinary("1111", "1111"));

    }

    public String addBinary(String a, String b) {


        String result = "";

        if (a != null && b != null) {

            a = a.trim();
            b = b.trim();

            int aLen = a.length() - 1;
            int bLen = b.length() - 1;

            int carry = 0;

            while (aLen >= 0 || bLen >= 0) {

                int aBit = 0;
                int bBit = 0;

                aBit = (aLen >= 0) ? Character.getNumericValue(a.charAt(aLen)) : 0;
                bBit = (bLen >= 0) ? Character.getNumericValue(b.charAt(bLen)) : 0;

                int sum = aBit + bBit + carry;

                carry = (sum > 1) ? 1 : 0;

                result = (sum % 2) + result;

                aLen--;
                bLen--;


            }

            if (carry == 1) {
                result = 1 + result;
            }

        }

        return result;


    }
}
