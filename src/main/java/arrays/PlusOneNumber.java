package arrays;

/**
 * Created by sarvothampai on 20/10/15.
 *
 * Add plus 1 to a number
 *
 */
public class PlusOneNumber {

    public static void main(String []args){

        PlusOneNumber obj =new PlusOneNumber();

        int digits[]={9};

        int []result =obj.plusOne(digits);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }

    public int[] plusOne(int[] digits) {

        int carry=1;
        for(int i=digits.length-1;i>=0;i--){

            int sum=digits[i]+carry;

            if(sum>=10){
                carry=1;
                digits[i]=0;
            }
            else{
                carry=0;
                digits[i]=sum;
            }

        }

        if(carry==0){
            return digits;
        }
        else{
            int []result=new int[digits.length+1];

            result[0]=carry;

            for(int i=0;i<digits.length;i++){
                result[1+i]=digits[i];
            }

            return result;

        }

    }
}
