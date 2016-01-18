package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 17/09/15.
 */
public class MinimumCoinProblem {


    public static void main(String []args){

        int i=12;

        MinimumCoinProblem obj=new MinimumCoinProblem();

        List<Integer> changes=obj.getChange(i);
        for(Integer change : changes ){
            System.out.print(change +" ");
        }


    }

    private List<Integer> getChange(int n){


        int []denominations={25,10,5,1};

        List<Integer> change =new ArrayList<Integer>();


        if(n!=0 && n>0){


            for(int denomination:denominations){

                if(n%denomination==0){
                    int q=n/denomination;
                    for(int i=0;i<q;i++){
                        change.add(denomination);
                    }
                    n=n%denomination;

                }
                else{
                    int q=n/denomination;
                    n=n%denomination;
                    for(int i=0;i<q;i++){
                        change.add(denomination);
                    }

                }

            }

        }

        return change;

    }


}
