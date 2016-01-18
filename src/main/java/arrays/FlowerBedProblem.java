package arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sarvothampai on 29/12/15.
 * <p/>
 * /*Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die. Given a flowerbed (represented as an array containing booleans), return if a given number of new flowers can be planted in it without violating the no-adjacent-flowers rule
 * Sample inputs
 * <p/>
 * Input: 1,0,0,0,0,0,1,0,0
 * <p/>
 * 3 => true
 * 4 => false
 * Input: 1,0,0,1,0,0,1,0,0
 * <p/>
 * 1 => true
 * 2 => false
 * input: 0
 * <p/>
 * 1 => true
 * 2 => false
 * <p/>
 * <p/>
 * Time complexity : O(N)
 */

public class FlowerBedProblem {

    public static void main(String[] args) {

        FlowerBedProblem obj = new FlowerBedProblem();
        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 3));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 3));
        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 4));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 4));
        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.TRUE,
                Boolean.FALSE,
                Boolean.FALSE,
                Boolean.TRUE,
                Boolean.FALSE, Boolean.FALSE,
                Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 1));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.TRUE,
                Boolean.FALSE,
                Boolean.FALSE,
                Boolean.TRUE,
                Boolean.FALSE, Boolean.FALSE,
                Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 1));

        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.TRUE,
                Boolean.FALSE,
                Boolean.FALSE,
                Boolean.TRUE,
                Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
                Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 2));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.TRUE,
                Boolean.FALSE,
                Boolean.FALSE,
                Boolean.TRUE,
                Boolean.FALSE, Boolean.FALSE, Boolean.FALSE,
                Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 2));

        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.FALSE), 1));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.FALSE), 1));
        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.FALSE), 2));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.FALSE), 2));
        System.out.println(obj.canPlaceFlowers(Arrays.asList(Boolean.FALSE), 1));
        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.FALSE), 1));

        System.out.println(obj.canPlaceFlowers2(Arrays.asList(Boolean.TRUE), 1));

    }

    public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
        this.hashCode();
        if (flowerbed == null || flowerbed.isEmpty() || numberToPlace < 0) {
            return false;
        }

        if (numberToPlace == 0)
            return true;

        if (flowerbed.size() == 1) {
            return !flowerbed.get(0) && numberToPlace == 1;
        }

        int counter = 0;

        for (int i = 0; i < flowerbed.size(); i++) {
            if (!flowerbed.get(i)) {
                if ((i == 0 && !flowerbed.get(i + 1))
                        || (i == flowerbed.size() - 1 && !flowerbed.get(i - 1))
                        || (!flowerbed.get(i + 1) && !flowerbed.get(i - 1))) {
                    //place the flower
                    flowerbed.set(i, true);
                    counter++;
                    if (counter == numberToPlace)
                        return true;
                }
            }
        }

        return false;
    }

    public boolean canPlaceFlowers2(List<Boolean> flowerbed, int numberToPlace) {

        System.out.println("2");

        if (flowerbed == null || flowerbed.size() == 0 || numberToPlace < 0) {
            return false;
        }

        if (numberToPlace == 0) {
            return true;
        }


        int numberOfSpots = 0;
        int prevIndex = -1;


        for (int i = 0; i < flowerbed.size() && numberOfSpots < numberToPlace; i++) {

            if (flowerbed.get(i)) {
                prevIndex = i;
                continue;
            } else {

                if (prevIndex == -1 || (prevIndex + 1 != i && i < flowerbed.size() - 1 && !flowerbed.get(i + 1))) {
                    numberOfSpots++;
                    prevIndex = i;
                }

            }

        }


        return numberOfSpots == numberToPlace;

    }

}
