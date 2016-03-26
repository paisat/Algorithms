package arrays;

/**
 * Created by sarvothampai on 11/03/16.
 * <p/>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p/>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p/>
 * <p/>
 *
 *
 * Time Complexity : log(N)
 */
public class FirstBadVersion {

    private int badVersion = 1;


    public static void main(String[] args) {

        FirstBadVersion obj = new FirstBadVersion();
        System.out.println(obj.firstBadVersion(1));

    }

    public int firstBadVersion(int n) {

        long low = 1;
        long high = n;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (!isBadVersion((int) mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return (int) low;

    }

    private boolean isBadVersion(int n) {
        return n == badVersion;
    }
}
