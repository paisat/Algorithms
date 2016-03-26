package bfsAndDfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Created by sarvothampai on 14/03/16.
 *
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

 Time Complexity : O(V+E)


 *
 *
 */
public class CourseSchedule {


    @Test
    public void test(){


        int numCourses=2;

        int [][]prereq=new int[1][2];

        prereq[0][0]=1;
        prereq[0][1]=0;

        CourseSchedule obj=new CourseSchedule();

        System.out.println(obj.canFinish(2,prereq));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses>0 && prerequisites!=null && prerequisites.length!=0){

            int rows=prerequisites.length;

            HashMap<Integer,List<Integer>> preReq=new HashMap<Integer,List<Integer>>();

            for(int i=0;i<rows;i++){

                if(preReq.containsKey(prerequisites[i][0])){
                    preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);
                }
                else{
                    List<Integer> dependencies=new ArrayList<Integer>();
                    dependencies.add(prerequisites[i][1]);
                    preReq.put(prerequisites[i][0],dependencies);
                }

            }

            System.out.println(preReq);

            HashSet<Integer> visited =new HashSet<Integer>();
            HashSet<Integer> recursion=new HashSet<Integer>();


            for(Map.Entry<Integer,List<Integer>> entry : preReq.entrySet() ){

                if(!visited.contains(entry.getKey())){

                    if(!courseScheduleHelper(entry.getKey(),visited,recursion,preReq)){
                        return false;
                    }
                }

            }

            return true;

        }

        return true;

    }

    private boolean courseScheduleHelper(int course , HashSet<Integer> visited ,HashSet<Integer> recursion ,HashMap<Integer,List<Integer>> dependencies ){

        visited.add(course);
        recursion.add(course);

        if(dependencies.containsKey(course)) {
            for (int c : dependencies.get(course)) {

                if (recursion.contains(c)) {
                    return false;
                } else if (!visited.contains(c) && !courseScheduleHelper(c, visited, recursion, dependencies)) {
                    return false;
                }

            }
        }

        recursion.remove(course);
        return true;

    }
}
