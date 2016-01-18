package arrays;

/**
 * Created by sarvothampai on 18/09/15.
 */
public class FindKSmallestElementInTwoSortedArrays {

    public static void main(String[] args) {

        FindKSmallestElementInTwoSortedArrays obj = new FindKSmallestElementInTwoSortedArrays();

        int a[] = { 1, 2, 3, 4 };
        int b[] = { 5, 6, 7, 8 };

        System.out.println(obj.findKSmallestElement(a, b, 1));


    }

    private Integer findKSmallestElement(int a[], int b[], int k) {

        int aLength = a.length;
        int bLength = b.length;

        if (k > aLength + bLength || (aLength == 0 && bLength == 0)) {
            return null;
        } else {

            int a1, a2, b1, b2;
            k=k-1;

            a1 = 0;
            a2 = aLength - 1;
            b1 = 0;
            b2 = bLength - 1;

            while (aLength != 0 || bLength != 0) {

                if (aLength == 0) {
                    return b[b1 + k];
                }

                if (bLength == 0) {
                    return a[a1 + k];
                }

                int aMid = (a2 + a1) / 2;
                int bMid = (b2 + b1) / 2;


                //ignore first half of a or b
                if (aMid + bMid < k) {

                    if (a[aMid] > b[bMid]) {
                        b1 = bMid + 1;
                        k = k - bMid ;
                    } else {
                        a1 = aMid + 1;
                        k = k - aMid ;
                    }

                } else {

                    //ignore second half of a or b
                    if (a[aMid] > b[bMid]) {
                        a2 = aMid;
                    } else {
                        b2 = bMid;
                    }
                }

                aLength = (a2 - a1) + 1;
                bLength = (b2 - b1) + 1;

            }


        }

        return null;

    }


}
