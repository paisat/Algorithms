package bfsAndDfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sarvothampai on 14/03/16.
 */
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int result[] = new int[numCourses];

        if (numCourses > 0 && prerequisites != null && prerequisites.length != 0) {

            int rows = prerequisites.length;

            HashMap<Integer, List<Integer>> preReq = new HashMap<Integer, List<Integer>>();

            for (int i = 0; i < rows; i++) {

                if (preReq.containsKey(prerequisites[i][0])) {
                    preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);
                } else {
                    List<Integer> dependencies = new ArrayList<Integer>();
                    dependencies.add(prerequisites[i][1]);
                    preReq.put(prerequisites[i][0], dependencies);
                }

            }

            System.out.println(preReq);

            HashSet<Integer> visited = new HashSet<Integer>();
            HashSet<Integer> recursion = new HashSet<Integer>();
            Stack<Integer> courseSchedule = new Stack<Integer>();


            for (Map.Entry<Integer, List<Integer>> entry : preReq.entrySet()) {

                if (!visited.contains(entry.getKey())) {

                    if (!courseScheduleHelper(entry.getKey(), visited, recursion, courseSchedule, preReq)) {
                        return result;
                    }
                }

            }


            int i = 0;
            while (!courseSchedule.isEmpty()) {
                result[i] = courseSchedule.pop();
                i++;
            }
        }

        return result;

    }

    private boolean courseScheduleHelper(int course, HashSet<Integer> visited, HashSet<Integer> recursion, Stack<Integer> courseSchedule, HashMap<Integer, List<Integer>> dependencies) {

        visited.add(course);
        recursion.add(course);

        if (dependencies.containsKey(course)) {
            for (int c : dependencies.get(course)) {

                if (recursion.contains(c)) {
                    return false;
                } else if (!visited.contains(c) && !courseScheduleHelper(c, visited, recursion, courseSchedule, dependencies)) {
                    return false;
                }

            }
        }

        recursion.remove(course);
        courseSchedule.add(course);
        return true;

    }
}
