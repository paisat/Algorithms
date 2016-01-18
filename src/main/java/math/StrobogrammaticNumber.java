package math;

/**
 * Created by sarvothampai on 21/12/15.
 *
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 For example, the numbers "69", "88", and "818" are all strobogrammatic.

 *
 */
public class StrobogrammaticNumber {

    public static void main(String []args){

        StrobogrammaticNumber obj=new StrobogrammaticNumber();

        System.out.println(obj.isStrobogrammatic("6009"));
        System.out.println(obj.isStrobogrammatic("6600099"));

    }

    public boolean isStrobogrammatic(String num) {

        if(num!=null && num.length()==0){
            return false;
        }

        String strobo="00 88 11 696";

        for(int i=0,j=num.length()-1;i<=j; i++,j-- ){
            String temp=num.charAt(i)+""+num.charAt(j);
            if(!strobo.contains(temp)){
                return false;
            }
        }

        return true;
    }
}
