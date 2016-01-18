package Strings;

/**
 * Created by sarvothampai on 29/09/15.
 */
public class ValidPalindrome{

    public static void main(String []args){


        ValidPalindrome palindrome =new ValidPalindrome();
        System.out.println(palindrome.isValidPlanindrome("race a car"));

    }

    public boolean isValidPlanindrome(String s){

        if(s==null){
            return false;
        }

        if(s.length()==0){

            return true;
        }

        int l=0;
        int r=s.length()-1;

        while(l<=r){

            char l1=Character.toUpperCase( s.charAt(l));
            char r1=Character.toUpperCase ( s.charAt(r));

            if(! Character.isLetterOrDigit(l1)){
                l++;

            }

            if( !Character.isLetterOrDigit(r1) ){
                r--;

            }

            if(Character.isLetterOrDigit(l1) && Character.isLetterOrDigit(r1) ){
                if(l1==r1){
                    l++;
                    r--;
                }
                else{
                    return false;
                }
            }

        }

        return true;


    }
}
