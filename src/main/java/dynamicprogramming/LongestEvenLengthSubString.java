package dynamicprogramming;

/**
 * Created by sarvothampai on 30/12/15.
 */
public class LongestEvenLengthSubString {


    public static void main(String []args){

        LongestEvenLengthSubString obj=new LongestEvenLengthSubString();
        System.out.println(obj.longestEvenLengthSubString("123123"));
        System.out.println(obj.longestEvenLengthSubString("1538023"));
        System.out.println(obj.longestEvenLengthSubString2("123123"));
        System.out.println(obj.longestEvenLengthSubString2("1538023"));

    }


    public int longestEvenLengthSubString2(String s){

        int result=0;

        if(s!=null && s.length()!=0){

            for(int i=1;i<s.length();i++){

                int low=i-1;
                int high=i;

                int lsum=0;int rsum=0;

                while(low>=0 && high<s.length()){

                    lsum=lsum+Character.getNumericValue(s.charAt(low));
                    rsum=rsum+Character.getNumericValue(s.charAt(high));

                    if(lsum==rsum){
                        result=Math.max(result,high-low+1);
                    }

                    low--;
                    high++;

                }

            }
        }

        return result;

    }


    public int longestEvenLengthSubString(String s){

        int result=0;

        if(s!=null && s.length()!=0){

            int sum[]=new int[s.length()+1];

            sum[0]=0;

            for(int i=1;i<=s.length();i++){
                sum[i]=sum[i-1]+Character.getNumericValue(s.charAt(i-1));
            }

            for(int i=2;i<=s.length();i=i+2){

                for(int j=0;j<=s.length()-i;j++){


                    if(sum[j+i/2]-sum[j]==sum[j+i]-sum[j+i/2]){
                        result=Math.max(result,i);
                    }

                }

            }


        }

        return result;

    }

}
