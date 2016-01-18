package Strings;

/**
 * Created by sarvothampai on 20/09/15.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class StringZigZag {

    public static void main(String []args){

        StringZigZag obj=new StringZigZag();
        System.out.println(obj.getZiZagString("ABCD", 5));

    }

    private String getZiZagString(String s,int numRows){

        if(s==null || s.length()==0 || numRows<=0 || numRows==1){
            return s;
        }
        else{

            String result="";
            int index=0;


            for(int i=0;i<numRows   ;i++){

                index=i;

                if(i==0 || i==numRows-1){


                    int stepCost=(numRows*2)-2;

                    while(index<=s.length()-1){

                        result =result+s.charAt(index);
                        index = index+stepCost;

                    }


                }
                else{

                    int stepCost = ((numRows*2)-2)-i*2;
                    int secondStepCost = 2*i;


                    int count=1;

                    while(index<=s.length()-1){

                        if(count%2==1){

                            result=result+s.charAt(index);
                            index=index+stepCost;
                        }
                        else {
                            result = result +s.charAt(index);
                            index=index+secondStepCost;
                        }

                        count++;

                    }

                }

            }

            return result;

        }

    }

}
