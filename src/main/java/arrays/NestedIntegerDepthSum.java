package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 29/12/15.
 * <p/>
 * <p/>
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 */

public class NestedIntegerDepthSum {


    public static void main(String[] args) {

        NestedIntegerDepthSum obj = new NestedIntegerDepthSum();


        NestedInteger i1 = new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1));
        NestedInteger i2 = new NestedIntegerImpl(2);
        NestedInteger i3 = new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1));

        List<NestedInteger> input1 = new ArrayList<NestedInteger>();
        input1.add(i1);
        input1.add(i2);
        input1.add(i3);


        NestedInteger i4 = new NestedIntegerImpl(1);
        NestedInteger i5 = new NestedIntegerImpl(new NestedIntegerImpl(4), new NestedIntegerImpl(new NestedIntegerImpl(6)));
        List<NestedInteger> input2 = new ArrayList<NestedInteger>();
        input2.add(i4);
        input2.add(i5);

        System.out.println(obj.depthSum(input1));
        System.out.println(obj.depthSum(input2));


    }


    public int depthSum(List<NestedInteger> input) {

        if (input == null || input.size() == 0) {
            return 0;
        }

        return depthSumHelper(input, 1);

    }


    private int depthSumHelper(List<NestedInteger> integers, int level) {

        int sum = 0;

        for (NestedInteger integer : integers) {
            if (integer.isInteger()) {
                sum = sum + integer.getInteger() * level;
            } else {
                sum = sum + depthSumHelper(integer.getList(), level + 1);
            }
        }

        return sum;
    }
}
