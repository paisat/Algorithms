package hash;

import java.util.HashSet;

/**
 * Created by sarvothampai on 10/12/15.
 * <p/>
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * <p/>
 * Time Complexity : O(N)
 */
public class PalindromePermutation {


    public static void main(String[] args) {

        PalindromePermutation permutation = new PalindromePermutation();

        System.out.println(permutation.canPermutatePalindrome("code"));
        System.out.println(permutation.canPermutatePalindrome("aab"));
        System.out.println(permutation.canPermutatePalindrome("carerac"));
        System.out.println(permutation.canPermutatePalindrome("aabb"));

    }


    public boolean canPermutatePalindrome(String s) {


        if (s != null && s.length() != 0) {


            HashSet<Character> charSet = new HashSet<Character>();

            for (int i = 0; i < s.length(); i++) {

                if (charSet.contains(s.charAt(i))) {
                    charSet.remove(s.charAt(i));
                } else {
                    charSet.add(s.charAt(i));
                }

            }

            // ==0 when there is even number . ==1 when string is odd
            return charSet.size() == 0 || charSet.size() == 1;


        }

        return false;

    }

}
