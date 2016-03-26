package math;

/**
 * Created by sarvothampai on 24/02/16.
 * <p/>
 * GIven sum of 3 sides of a cuboid . Find mAximum volume;
 */
public class MaxVolume {


    public int getMaxVolume(int n) {
        int k = n / 3;

        if (n % 3 == 0) {
            return k * k * k;
        } else if (n % 3 == 2) {
            return ((k + 1) * (k + 1) * k);
        } else {
            return ((k + 1) * k * k);
        }

    }
}
