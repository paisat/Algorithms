package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sarvothampai on 11/11/15.
 * <p/>
 * Complexity : O(n*n!)
 */
public class FindAllPermutationsOfString {


    public static void main(String[] args) {

        FindAllPermutationsOfString obj = new FindAllPermutationsOfString();
        System.out.println(obj.findPermutations("apple", 2));
        System.out.println(obj.findPermutationsRepetitionAllowed("cat", 2));

    }


    /*
    *
    *
    * Time Complexity : O(n^n)
    *
    * */
    public Set<String> findPermutationsRepetitionAllowed(String s, int k) {
        Set<String> result = new HashSet<String>();


        if (s != null && s.length() != 0) {

            permutationWithRepititioOfCharactersAllowed("", s, result, k);
        }

        return result;

    }


    public Set<String> findPermutations(String s, int k) {


        Set<String> result = new HashSet<String>();

        if (s != null && s.length() != 0) {
            permutation("", s, result, k);
        }

        return result;
    }


    private void permutationWithRepititioOfCharactersAllowed(String prefix, String str, Set<String> permutations, int k) {

        if (prefix.length() == k) {
            permutations.add(new String(prefix));
        } else {
            for (int i = 0; i < str.length(); i++) {
                permutationWithRepititioOfCharactersAllowed(prefix + str.charAt(i), str, permutations, k);
            }
        }

    }


    private void permutation(String prefix, String str, Set<String> permutations, int k) {


        if (prefix.length() == k) {
            permutations.add(new String(prefix));
        } else {

            for (int i = 0; i < str.length(); i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), permutations, k);

            }

        }


    }


}