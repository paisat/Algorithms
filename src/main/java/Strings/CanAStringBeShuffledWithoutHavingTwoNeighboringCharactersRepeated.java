package Strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 12/03/16.
 * <p/>
 * <p/>
 * TODO Google
 * <p/>
 * Define a function that can detect whether the characters of a string can be shuffled without repeating same characters as one other's neighbors. E.g. :
 * apple >> alpep, so valid
 * a >> a, valid
 * aa >> aa, invalid/impossible
 * aab >> aba, valid
 * aaaabbcc >> acabacab, valid
 * etc.
 * You do not have to find one representation, just have to detect if it is possible or not!
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * Space complexity : O(1)
 */
public class CanAStringBeShuffledWithoutHavingTwoNeighboringCharactersRepeated {

    @Test
    public void test() {

        CanAStringBeShuffledWithoutHavingTwoNeighboringCharactersRepeated obj = new CanAStringBeShuffledWithoutHavingTwoNeighboringCharactersRepeated();

        Assert.assertTrue(obj.canStringBeShuffledWithoutRepeatingNeighbors("aaaabbcc"));
        Assert.assertFalse(obj.canStringBeShuffledWithoutRepeatingNeighbors(""));
        Assert.assertFalse(obj.canStringBeShuffledWithoutRepeatingNeighbors("aa"));
        Assert.assertTrue(obj.canStringBeShuffledWithoutRepeatingNeighbors("aabb"));
        Assert.assertTrue(obj.canStringBeShuffledWithoutRepeatingNeighbors("aab"));


    }

    public boolean canStringBeShuffledWithoutRepeatingNeighbors(String s) {


        if (s != null && s.length() != 0) {

            int count[] = new int[256];

            for (int i = 0; i < s.length(); i++) {
                Character ch = s.charAt(i);
                count[ch]++;
            }

            int maxOccuringCharacterCount = 0;

            for (int i = 0; i < 256; i++) {
                maxOccuringCharacterCount = Math.max(count[i], maxOccuringCharacterCount);
            }

            return maxOccuringCharacterCount - 1 <= s.length() - maxOccuringCharacterCount;
        }

        return false;
    }


}
