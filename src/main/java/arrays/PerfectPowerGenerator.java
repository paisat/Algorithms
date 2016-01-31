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


    public static void main(String []args){

        PerfectPowerGenerator obj=new PerfectPowerGenerator();
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());


    }

    private long next = 4;
    private int base = 2;

    /* b = logn/loga */
    private int isPerfectPower(long n) {
        for (int a=2; a<n/2; ++a) {
            double b = Math.log(n) / Math.log(a);
            if (b - (int)b == 0) return a;
        }
        return -1;
    }


    public Long next() {
        long pre = next;
        next = next*base;
        for (long i=pre+1; i<next; ++i) {
            int a = isPerfectPower(i);
            if (a > 0) {
                next = i;
                System.out.println("a = "+a);
                base=a;
                break;
            }
        }
        return pre;
    }


    public void reset() {
        next = 4; base = 2;
    }
}
