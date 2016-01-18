package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 29/12/15.
 */
public class NestedIntegerImpl implements NestedInteger {

    private Integer integer;

    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer i) {
        this.integer = i;
    }

    public NestedIntegerImpl(NestedInteger... integers){

        if(integers!=null){
            list=new ArrayList<NestedInteger>();
            for(NestedInteger integer:integers){
                list.add(integer);
            }
        }

    }

    public NestedIntegerImpl(List<NestedInteger> nestedIntegerList ){

        this.list=nestedIntegerList;
    }

    public boolean isInteger() {
        if (integer != null) {
            return true;
        }

        return false;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}
