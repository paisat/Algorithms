package arrays;

/**
 * Created by sarvothampai on 08/10/15.
 * <p/>
 * Do not have to handle equal case. It gets handled by itself;
 * Take care of case where m is zero and not n;
 * <p/>
 * Have to dump remaining element in n to m;
 * <p/>
 * <p/>
 * Time Complexity : O(M+N)
 */

public class MergeTwoSortedArraysWithConstantExtraSpace {

    public static void main(String[] args) {

        MergeTwoSortedArraysWithConstantExtraSpace obj = new MergeTwoSortedArraysWithConstantExtraSpace();


        int nums1[] = { 2, 0 };
        int m = 2;
        int nums2[] = { 1 };
        int n = 1;

        obj.merge(nums1, m, nums2, n);

        for (int i = 0; i < (m + n); i++) {
            System.out.println(nums1[i]);
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        while (m > 0 && n > 0) {

            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }

        while (n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n--;
        }

    }

}
