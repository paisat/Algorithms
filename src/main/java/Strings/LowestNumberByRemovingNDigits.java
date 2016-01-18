package Strings;

/**
 * Created by sarvothampai on 27/12/15.
 *
 * Build Lowest Number by Removing n digits from a given number
 Given a string ‘str’ of digits and an integer ‘n’,
 build the lowest possible number by removing ‘n’ digits from the string and not changing the order of input digits.

 O(string length *n)

 *
 */
public class LowestNumberByRemovingNDigits {


    public static void main(String []args){


        LowestNumberByRemovingNDigits obj=new LowestNumberByRemovingNDigits();

        System.out.println(obj.lowestNumber("121198",2));
        System.out.println(obj.lowestNumber("765028321",5));
        System.out.println(obj.lowestNumber("4325043",3));



    }


    public String lowestNumber(String number,int n){


        StringBuilder result=new StringBuilder();

        if(number!=null && number.length()!=0 && n>=0){

            lowestNumberHelper(number,n,result);


        }

        return result.toString();


    }

    private void lowestNumberHelper(String nummber,int n,StringBuilder result){


        if(n==0){
            result.append(nummber);
            return;
        }

        if(nummber.length()<=n){
            return;
        }

        int minIndex=0;

        for(int i=1;i<=n;i++){

            char ch=nummber.charAt(i);

            if(ch<nummber.charAt(minIndex)){
                minIndex=i;
            }

        }

        result.append(nummber.charAt(minIndex));

        lowestNumberHelper(nummber.substring(minIndex+1),n-minIndex,result);


    }
}
