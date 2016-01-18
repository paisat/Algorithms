package javaquirks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by sarvothampai on 22/10/15.
 */
public class Cloning implements Cloneable {

    private int sa;
    private List<String> list;

    private String[] a;
    private String df;

    public Cloning(int sa, List<String> lists,String[] a,String df) {
        this.sa = sa;
        this.list = lists;
        this.a=a;
        this.df=df;
    }


    public int getSa() {
        return sa;
    }

    public void setSa(int sa) {
        this.sa = sa;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }


    public static void main(String[] args) throws Exception {



        List<String> arrays = new ArrayList<String>();
        arrays.add("23");
        arrays.add("3232");

        Cloning obj = new Cloning(3, arrays,new String[]{"sa","sas"},"sds");

        Cloning clone = (Cloning) obj.clone();

        clone.getList().remove(0);
        clone.a[0]="sasa";

        System.out.println(obj.list);
        System.out.println(obj.a[0]);

        Object a[]={new Object(),new Object()};

        Object b[]=a.clone();



        System.out.println(a[0]);
        System.out.println(b[0]);

    }



}
