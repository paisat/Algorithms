package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 12/12/15.
 * <p/>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p/>
 * For example:
 * Given "25525511135",
 * <p/>
 * return ["255.255.11.135", "255.255.111.35"].
 * (Order does not matter)
 * <p/>
 * Time Complexity : O(n^3)
 *
 *
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<String>();


        if (s != null && s.length() != 0) {

            int length = s.length();

            //length -2 is only for checking valid
            for (int i = 1; i < 4 && i < length ; i++) {
                for (int k = i + 1; k - i < 4 && k < length ; k++) {
                    for (int l = k + 1; l < k + 4 && l < length; l++) {

                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, k);
                        String s3 = s.substring(k, l);
                        String s4 = s.substring(l, length);

                        if (isIpAdrressValid(s1) && isIpAdrressValid(s2) && isIpAdrressValid(s3) && isIpAdrressValid(s4)) {
                            result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }

                    }
                }
            }

        }

        return result;

    }

    private boolean isIpAdrressValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;

    }


}
