package hash;

import java.util.HashMap;

/**
 * Created by sarvothampai on 24/12/15.
 * <p/>
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p/>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p/>
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * <p/>
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

public class TwoSumDSDesign {

    HashMap<Integer, Integer> lTable = new HashMap<Integer, Integer>();

    public void add(int number) {
        // Since this is two sum, we actually do not need the count over 2.
        lTable.put(number, lTable.get(number) == null ? 1 : 2);
    }

    public boolean find(int value) {
        for (int key : lTable.keySet()) {
            int res = value - key;
            Integer occr = lTable.get(res);
            // add(0) find(0)  . add(0) add(0) and find(0) . Condition required for this.
            if (occr != null && (occr == 2 || (occr == 1 && key != res))) {
                return true;
            }
        }
        return false;
    }

}
