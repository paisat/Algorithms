package math;

/**
 * Created by sarvothampai on 15/01/16.
 */
public class ComplementOfANumber {

    public static void main(String []args){

        ComplementOfANumber obj=new ComplementOfANumber();
        System.out.println(obj.getComplement(4));
    }

    public int getComplement(int n){


        int temp=n;
        int result=0;
        int i=0;

        while (temp!=0){

            int r = temp%2;
            int complement=(r==0)?1:0;
            result=result+complement * (1<<i) ;
            i++;
            temp=temp/2;

        }

        return result;
    }
}
