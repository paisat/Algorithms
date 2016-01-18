package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sarvothampai on 11/12/15.
 * <p/>
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 * <p/>
 * 1
 * b) d|o|g                   --> d1g
 * <p/>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p/>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p/>
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p/>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 */
public class ValidWordAbbreviation {


    public static void main(String[] args) {

        String[] dictionary = { "deer", "door", "cake", "card" };

        ValidWordAbbreviation obj = new ValidWordAbbreviation(dictionary);

        //System.out.println(obj.isUnique("dear"));
        System.out.println(obj.isUnique("door"));
        //System.out.println(obj.isUnique("cane"));
        //System.out.println(obj.isUnique("make"));

    }


    HashMap<String, Set<String>> map;

    public ValidWordAbbreviation(String[] dictionary) {

        map = new HashMap<String, Set<String>>();

        for (String s : dictionary) {
            if (!map.containsKey(getAbbreviation(s))) {
                HashSet<String> set = new HashSet<String>();
                set.add(s);
                map.put(getAbbreviation(s), set);
            } else {
                map.get(getAbbreviation(s)).add(s);
            }

        }

    }

    private String getAbbreviation(String s) {

        String abbr = s;

        if (s.length() > 2) {
            int length = s.length() - 2;
            abbr = s.charAt(0) + "" + length + s.charAt(s.length() - 1);
        }

        return abbr;
    }

    public boolean isUnique(String word) {

        if (!map.containsKey(getAbbreviation(word)) || (map.containsKey(getAbbreviation(word))
                && map.get(getAbbreviation(word)).contains(word) && map.get(getAbbreviation(word)).size() == 1)) {
            return true;
        }

        return false;

    }
}
