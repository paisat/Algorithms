package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sarvothampai on 11/12/15.
 * <p/>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p/>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p/>
 * For example,
 * <p/>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p/>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {

        RepeatedDNASequences obj = new RepeatedDNASequences();

        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(obj.findRepeatedDnaSequences(str));

    }


    public List<String> findRepeatedDnaSequences(String s) {


        List<String> result = new ArrayList<String>();

        if (s != null && s.length() != 0) {

            HashSet<String> set = new HashSet<String>();
            HashSet<String> seen = new HashSet<String>();


            for (int i = 0; i <= s.length() - 10; i++) {

                String str = s.substring(i, i + 10);

                if (!seen.add(str)) {
                    set.add(str);
                }

            }

            result.addAll(set);

        }

        return result;


    }

}
