package bfsAndDfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 25/03/16.
 * <p/>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * Example 1:
 * 0          3
 * |          |
 * 1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * Example 2:
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 *
 *
 * Time Complexity :
 *
 * Space Complexity :
 *
 *
 */
public class NumberOfConnectedComponentsInUndirectedGraph {


    @Test
    public void test() {

        NumberOfConnectedComponentsInUndirectedGraph obj = new NumberOfConnectedComponentsInUndirectedGraph();

        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };

        Assert.assertEquals(2, obj.numberOfComponents(5, edges));
        Assert.assertEquals(1, obj.numberOfComponents(5, edges2));

    }


    public int numberOfComponents(int n, int[][] edges) {

        if (n > 0 && edges != null && edges.length != 0) {


            HashMap<Integer, List<Integer>> parentChildMap = new HashMap<Integer, List<Integer>>();

            int father[] = new int[n];

            for (int i = 0; i < n; i++) {
                father[i] = i;
            }


            for (int i = 0; i < edges.length; i++) {
                union(edges[i][0], edges[i][1], father);
            }

            for (int i = 0; i < n; i++) {
                int parent = find(i, father);

                if(parentChildMap.containsKey(parent)){
                    parentChildMap.get(parent).add(i);
                }
                else {
                    List<Integer> childeren=new ArrayList<Integer>();
                    childeren.add(i);
                    parentChildMap.put(parent,childeren);

                }


            }


            System.out.println(parentChildMap);

            return parentChildMap.size();

        }

        return 0;

    }

    private void union(int node1, int node2, int father[]) {
        father[find(node1, father)] = find(node2, father);
    }


    private int find(int node, int[] father) {

        if (father[node] == node) {
            return node;
        }

        father[node] = find(father[node], father);

        return father[node];
    }

}
