package arrays;

/**
 * Created by sarvothampai on 19/01/16.
 *
 * One way is to maintain a min-heap of several power values of prime numbers.
 At beginning, the heap only contains [2, 4]. It is ordered by power values (not base)
 Next, return 4.

 Inside the iterator, increase 4 to 8 by multiplying 2, i.e. remove heap top [2, 4] and add [2, 8].
 Also find prime numbers between old heap top 4 and new heap top 8, which is 3.
 Add [3, 9] to the heap.

 Next, return 8.
 Remove [2, 8] and add [2, 16].
 Find prime numbers between 8 and 9, which is null.
 Next, return 9.
 Remove [3, 9] and add [3, 27].
 Find prime numbers between 9 and 16, which are 5, 7, 11, and 13.
 Add [5, 25], [7, 49], [11, 121], [13, 169] to the heap.
 ... ...
 *
 */
public class PerfectPowerGenerator {
}
