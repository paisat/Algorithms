package javaquirks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by sarvothampai on 23/10/15.
 */
public class JavaSorting {

    public static void main(String[] args) {


        List<Data> dataList = new ArrayList<Data>();

        JavaSorting obj = new JavaSorting();
        JavaSorting.Data data1 = obj.new Data("sas");
        JavaSorting.Data data2 = obj.new Data("zz");
        JavaSorting.Data data3 = obj.new Data("bn");
        JavaSorting.Data data4 = obj.new Data("sas");
        JavaSorting.Data data5 = obj.new Data("rtr");

        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);
        dataList.add(data5);

        Collections.sort(dataList, new Comparator<Data>() {
            public int compare(Data o1, Data o2) {
                return o2.val.compareTo(o1.val);
            }
        });

        for (Data data : dataList) {
            System.out.println(data.val);
        }


        LinkedList<Integer> linkedList = new LinkedList<Integer>();


        linkedList.add(0, new Integer(2));

        Map<String, String> map = new java.util.HashMap<String, String>();
        map.put("sds", "ds");


        Stack<Integer> stack = new Stack<Integer>();


        Set<String> keySet = map.keySet();

        Set<Map.Entry<String, String>> entrySet = map.entrySet();


        Iterator<String> iterator = keySet.iterator();

        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();


        System.out.println(map.get("sds"));

        HashSet<Integer> set = new HashSet<Integer>();


        Set<Integer> linkedSet = new LinkedHashSet<Integer>();
        linkedSet.add(new Integer(3));


        Set<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(new Integer(3));
        treeSet.remove(3);
        treeSet.isEmpty();
        treeSet.contains(3);
        treeSet.iterator();


        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(new Integer(3));
        queue.remove(3);
        queue.peek();
        queue.poll();
        queue.isEmpty();
        queue.contains(3);

    }


    private class Data {

        String val;

        public Data(String val) {
            this.val = val;
        }

    }

}
