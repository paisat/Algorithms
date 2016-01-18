package TestCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by sarvothampai on 29/09/15.
 */
public class Test {

    public class test2{

    }

    public static void main(String []args){



        List<Integer> arrayList =new ArrayList<Integer>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Iterator<Integer> iterator =arrayList.iterator();

        while (iterator.hasNext()){

            Integer i=iterator.next();
            if(i==2){
                iterator.remove();
            }

        }

        for(Integer i:arrayList){
            System.out.println(i);
        }





    }


    private void setNumber(Integer i){
        i=5;
    }


    private void recurse(int path[],int pathLen){

        if(pathLen==10){
            return;
        }

        path[pathLen++]=pathLen;

        recurse(path,pathLen);

        for(int i=0;i<10;i++){
            System.out.print(i+" ");

        }


        System.out.println("====");

        recurse(path,pathLen);

        for(int i=0;i<10;i++){
            System.out.print(i+" ");

        }


        System.out.println();

    }


}
