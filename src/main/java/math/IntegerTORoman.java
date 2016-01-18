package math;

/**
 * Created by sarvothampai on 25/12/15.
 */
public class IntegerTORoman {



    public String intToRoman(int num) {

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < values.length; i++) {
            //inputs like 2 ii need while loop.
            while (num >= values[i]) {
                sb.append(strs[i]);
                num = num - values[i];
            }
        }

        return sb.toString();
    }


}
