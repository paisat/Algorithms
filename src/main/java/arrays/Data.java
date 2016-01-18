package arrays;

import java.util.Collection;

/**
 * Created by sarvothampai on 16/01/16.
 */
public interface Data<T> {

    // Does this Data hold a collection?
    boolean isCollection();

    int a = 23;

    // Returns the collection contained by
    // this Data, or null if it is a single element
    Collection<Data<T>> getCollection();

    // Returns the single element contained
    //by this Data, or null if it is  collection
    T getElement();

}
