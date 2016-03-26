package math;

/**
 * Created by sarvothampai on 16/03/16.
 * The key to solve this problem is the count of 1s of each bit of all numbers.
 * <p/>
 * Take one bit number for example: nums = [1, 1, 1, 0, 0, 0, ..., x] . All numbers are 0 or 1.
 * <p/>
 * We know that every number appears three times except for just one number. So, if the count of 1s in nums is 0, 3, 6, ..., 3 * n, then the single number is 0. And if the count of 1s in nums is 1, 4, 7, ..., 3*n+1, then the single number is 1.
 * <p/>
 * So, for an array " nums " that contains only 0 or 1, the code to find the single number are:
 * <p/>
 * count = 0
 * for num in nums:
 * count = (count + num) % 3
 * return count
 * To make "count" less than 3, mod "count" with 3 in every loop.
 * <p/>
 * Below is the procedure for finding the single number in [1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0]:
 * <p/>
 * Table 1:
 * ++=======++===+===+===+===+===+===+===+===+===+===+===+===+===+====++
 * || num   ||   | 1 | 0 | 1 | 1 | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 | 0  ||
 * ++-------++---+---+---+---+---+---+---+---+---+---+---+---+---+----++
 * || count || 0 | 1 | 1 | 2 | 0 | 0 | 1 | 1 | 2 | 2 | 0 | 0 | 1 | 1* ||
 * ++=======++===+===+===+===+===+===+===+===+===+===+===+===+===+====++
 * So the single number is 1.
 * <p/>
 * We can write the calculate table for expression "count' = (count + num) % 3":
 * <p/>
 * Table 2:
 * ++=======+=====+========++
 * || count | num | count' ||
 * ++-------+-----+--------++
 * ||   0   |  0  |   0    ||
 * ++-------+-----+--------++
 * ||   1   |  0  |   1    ||
 * ++-------+-----+--------++
 * ||   2   |  0  |   2    ||
 * ++-------+-----+--------++
 * ||   0   |  1  |   1    ||
 * ++-------+-----+--------++
 * ||   1   |  1  |   2    ||
 * ++-------+-----+--------++
 * ||   2   |  1  |   0    ||
 * ++-------+-----+--------++
 *
 * To extend this algorithm to 32bits number. We need to rewrite these code to bit operation expressions.
 * <p/>
 * And the key is rewriting the expression " count' = (count + num) % 3 " to bit operation expressions.
 * <p/>
 * Write binary numbers of " count " and " count' " in "Table 2". And split their bits into two column:
 * <p/>
 * Table 3:
 *
 *
 * ++=======+============+=====+============+========++
 * ||       |    count   | num |   count'   |        ||
 * || count |    (bin)   |     |   (bin)    | count' ||
 * || (dec) ++=====+=====+=====+=====+=====++ (dec)  ||
 * ||       || b1  | b0  | num | b1' | b0' ||        ||
 * ++-------++-----+-----+-----+-----+-----++--------++
 * ||   0   ||  0  |  0  |  0  |  0  |  0  ||   0    ||
 * ++-------++-----+-----+-----+-----+-----++--------++
 * ||   1   ||  0  |  1  |  0  |  0  |  1  ||   1    ||
 * ++-------++-----+-----+-----+-----+-----++--------++
 * ||   2   ||  1  |  0  |  0  |  1  |  0  ||   2    ||
 * ++-------++-----+-----+-----+-----+-----++--------++
 * ||   0   ||  0  |  0  |  1  |  0  |  1  ||   1    ||
 * ++-------++-----+-----+-----+-----+-----++--------++
 * ||   1   ||  0  |  1  |  1  |  1  |  0  ||   2    ||
 * ++-------++-----+-----+-----+-----+-----++--------++
 * ||   2   ||  1  |  0  |  1  |  0  |  0  ||   0    ||
 * ++=======++===========+=====+===========++========++
 * <p/>
 * <p/>
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * <p/>
 * <p/>
 * <p/>
 * Note if a number repeats 2 times then you have to return c1
 */
public class SingleNumber2 {


    public static void main(String[] args) {


        SingleNumber2 obj = new SingleNumber2();
        System.out.println(obj.singleNumber(new int[] { 2, 2, 2, 1, 1 }));

    }

    public int singleNumber(int[] nums) {

        int result = 0;

        if (nums != null && nums.length != 0) {

            int c1 = 0;
            int c0 = 0;

            for (int n : nums) {

                int n0 = (~c1 & c0 & ~n) | (~c1 & ~c0 & n);
                int n1 = (c1 & ~c0 & ~n) | (~c1 & c0 & n);
                c0 = n0;
                c1 = n1;
            }

            result = c0;
        }

        return result;

    }
}
