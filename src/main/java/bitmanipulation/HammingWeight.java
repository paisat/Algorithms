package bitmanipulation;

/**
 * Created by sarvothampai on 11/12/15.
 */
public class HammingWeight {

    public static void main(String[] args) {

        HammingWeight obj = new HammingWeight();

        System.out.println(obj.hammingWeight(2));

    }

    public int hammingWeight(int n) {

        int count = 0;

        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                count++;
            }
        }

        return count;


    }
}
