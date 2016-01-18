package Strings;

import java.util.Map;

/**
 * Created by sarvothampai on 28/12/15.
 * <p/>
 * <p/>
 * Given string say ABCGRETCABCG and substring length let us take length as 3,
 * find the count of possible substrings, for example in above string ABC => 2 and BCG => 2 ,
 * where CGR and other 3 word length substrings has a count of 1.
 * <p/>
 * Time Complexity : O(m*length)
 * Space Complexity : O(length)
 */
public class SameSubstringOfCertainLength {


    public static void main(String[] args) {


        SameSubstringOfCertainLength obj = new SameSubstringOfCertainLength();

        System.out.println(obj.getSubStringMap("ABCGRETCABCG", 3));


    }


    public Map<String, Integer> getSubStringMap(String s, int length) {


        Map<String, Integer> resultMap = new java.util.HashMap<String, Integer>();


        if (s != null && s.length() != 0 && length > 0) {


            for (int i = 0; i <= s.length() - length; i++) {

                String subStr = s.substring(i, i + length);

                if (resultMap.containsKey(subStr)) {
                    resultMap.put(subStr, resultMap.get(subStr) + 1);
                } else {
                    resultMap.put(subStr, 1);
                }

            }


        }

        return resultMap;

    }

}
