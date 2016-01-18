package math;

/**
 * Created by sarvothampai on 18/12/15.
 */
public class PalindromeNumber {

    public static void main(String []args){

        int n=1;

        PalindromeNumber obj=new PalindromeNumber();
        System.out.println(obj.isPalindrome(n));

    }

    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }

        if(x==0){
            return true;
        }

        int y=0;
        int temp=x;
        while(x!=0){
            int r=x%10;
            x=x/10;
            y=y*10+r;

        }

        if(y==temp){
            return true;
        }

        return false;

    }
}
