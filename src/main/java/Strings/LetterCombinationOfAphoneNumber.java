package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sarvothampai on 21/10/15.
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


 *
 */
public class LetterCombinationOfAphoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();

        if (digits != null && digits.length() != 0) {

            Map<String, String> map = new HashMap<String, String>();

            map.put("2", "abc");
            map.put("3", "def");
            map.put("4", "ghi");
            map.put("5", "jkl");
            map.put("6", "mno");
            map.put("7", "pqrs");
            map.put("8", "tuv");
            map.put("9", "wxyz");

            List<Character> string = new ArrayList<Character>();

            String combination="";

            for(int i=0;i<digits.length();i++){
                combination=combination+map.get(digits.charAt(i)+"");
            }

            combinationUtil(result, string, digits, map);

        }
        return result;
    }


    private void combinationUtil(List<String> result, List<Character> string, String digits, Map<String, String> map) {


        if (digits.length() == 0) {

            String combinations = "";

            for (Character a : string) {
                combinations += a;
            }

            result.add(combinations);
            return;

        }


        String letters = map.get(digits.substring(0, 1));
        for (int i = 0; i < letters.length(); i++) {
            string.add(letters.charAt(i));
            combinationUtil(result, string, digits.substring(1), map);
            string.remove(string.size() - 1);
        }

    }
}
