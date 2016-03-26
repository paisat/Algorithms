package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 11/11/15.
 */
public class CombinationsOfAString {


    public static void main(String[] args) {

        CombinationsOfAString obj = new CombinationsOfAString();

        System.out.println(obj.combinationsOfAString("123", 3));
        //System.out.println(obj.combinationsOfAStringWithoutRepititions("121", 2));


    }


    public List<String> combinationsOfAString(String s, int k) {


        List<String> combinations = new ArrayList<String>();

        if (s != null && s.length() != 0 && k > 0) {
            combinationHelper("", s, combinations, k, 0);
        }

        return combinations;
    }

    public List<String> combinationsOfAStringWithoutRepititions(String s, int k) {


        List<String> combinations = new ArrayList<String>();

        if (s != null && s.length() != 0 && k > 0) {
            boolean used[] = new boolean[256];
            combinationHelperWithoutRepetitions("", s, combinations, k, 0, used);
        }

        return combinations;
    }


    private void combinationHelperWithoutRepetitions(String prefix, String str, List<String> combinations, int k, int start, boolean used[]) {

        if (prefix.length() == k) {
            combinations.add(new String(prefix));

        } else {

            for (int i = start; i < str.length(); i++) {

                if (used[str.charAt(i)]) {
                    continue;
                }

                used[str.charAt(i)] = true;
                combinationHelperWithoutRepetitions(prefix + str.charAt(i), str, combinations, k, i + 1, used);


            }

        }

    }

    private void combinationHelper(String prefix, String str, List<String> combinations, int k, int start) {

        if (prefix.length()==k) {
            combinations.add(new String(prefix));
        } else {
            for (int i = start; i < str.length(); i++) {
                combinationHelper(prefix + str.charAt(i), str, combinations, k, i + 1);
            }
        }
    }
}
