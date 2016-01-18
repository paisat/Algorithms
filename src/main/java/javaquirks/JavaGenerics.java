package javaquirks;

/**
 * Created by sarvothampai on 08/01/16.
 *
 * Generics can be even applied to interfaces.
 *
 */
public class JavaGenerics<T> {

    class DemoClass<T> {
        //T stands for "Type"
        private T t;

        public void set(T t) { this.t = t; }

        public T get() { return t; }


    }

    //DemoClass<Integer> obj=new DemoClass<Integer>();
    //There cannot be generic with static variables
    public static int ans;


    //method geberics
    //All T should be of the same type
    public static <T> int countAllOccurrences(T[] list, T item) {
        int count = 0;
        if (item == null) {
            for ( T listItem : list )
                if (listItem == null)
                    count++;
        }
        else {
            for ( T listItem : list )
                if (item.equals(listItem))
                    count++;
        }
        return count;
    }
}
