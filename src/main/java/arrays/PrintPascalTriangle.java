package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 12/11/15.
 *
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 Time Complexity : O(n^2)

 C(n,r)=(C(n,r-1)*(n-r+1))/r

 *
 */
public class PrintPascalTriangle {


    public static void main(String []args){

        PrintPascalTriangle obj =new PrintPascalTriangle();

        System.out.println(obj.generate(4));
        System.out.println(obj.getRow(4));

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result  =new ArrayList<List<Integer>>();

        if(numRows>=1){


            for(int line=1;line<=numRows;line++){

                int C=1;
                List<Integer> row =new ArrayList<Integer>();

                for(int k=1;k<=line;k++){
                    row.add(C);
                    C=C*(line-k)/k;
                }

                result.add(row);

            }

        }

        return result;


    }

    public List<Integer> getRow(int rowIndex) {


        List<Integer> row =new ArrayList<Integer>();

        if(rowIndex>=0) {


            rowIndex++;
            Long C = 1L;

            for (Integer k = 1; k <= rowIndex; k++) {
                row.add(C.intValue());
                C = C * (rowIndex - k) / k;
            }
        }

        return row;

    }

}
