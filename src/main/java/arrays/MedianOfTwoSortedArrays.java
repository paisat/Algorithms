package arrays;

/**
 * Created by sarvothampai on 19/09/15.
 * <p>
 * <p>
 * Time Complexity : O(Log n)
 */
public class MedianOfTwoSortedArrays {


//    int getMedian(int ar1[], int ar2[], int n)
//    {
//        int m1; /* For median of ar1 */
//        int m2; /* For median of ar2 */
//
//    /* return -1  for invalid input */
//        if (n <= 0)
//            return -1;
//
//        if (n == 1)
//            return (ar1[0] + ar2[0])/2;
//
//        if (n == 2)
//            return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
//
//        m1 = median(ar1, n); /* get the median of the first array */
//        m2 = median(ar2, n); /* get the median of the second array */
//
//    /* If medians are equal then return either m1 or m2 */
//        if (m1 == m2)
//            return m1;
//
//     /* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
//        if (m1 < m2)
//        {
//            if (n % 2 == 0)
//                return getMedian(ar1 + n/2 - 1, ar2, n - n/2 +1);
//            else
//                return getMedian(ar1 + n/2, ar2, n - n/2);
//        }
//
//    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
//        else
//        {
//            if (n % 2 == 0)
//                return getMedian(ar2 + n/2 - 1, ar1, n - n/2 + 1);
//            else
//                return getMedian(ar2 + n/2, ar1, n - n/2);
//        }
//    }


    int median(int arr[], int n) {
        if (n % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2;
        else
            return arr[n / 2];
    }


}
