package javaquirks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sarvothampai on 06/10/15.
 */
public class DataStructures {

    public static void main(String []args){
        List<Integer> list=new ArrayList<Integer>();
        Iterator<Integer> integerIterator =list.iterator();

        Hashtable<String,String> table=new Hashtable<String, String>();





        Comparator<Integer> integerComparator=new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };



        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }
}
