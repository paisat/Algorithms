package bfsAndDfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 13/03/16.
 * <p/>
 * Detect if theres a cycle in directed Graph;
 * <p/>
 * DFS
 * TIme Complexity O(V+E)
 * <p/>
 * Space Complexity : O(H)
 * <p/>
 * Where H is the height of the tree.
 */
public class DetectCycleInADirectedGraph {


    @Test
    public void test() {

        DetectCycleInADirectedGraph obj = new DetectCycleInADirectedGraph();

        List<Edge> edges = new ArrayList<Edge>();
        List<Vertex> vertices = new ArrayList<Vertex>();


        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);

        Edge e1 = new Edge(v1, v2);
        edges.add(e1);

        Edge e2 = new Edge(v2, v3);
        Edge e3 = new Edge(v2, v4);
        edges.add(e2);
        edges.add(e3);

        Edge e4 = new Edge(v3, v1);
        edges.add(e4);

        Edge e5 = new Edge(v4, v3);
        edges.add(e5);


        v1.addEdge(e1);
        v2.addEdge(e2);
        v2.addEdge(e3);
        v3.addEdge(e4);
        v4.addEdge(e5);

        Assert.assertTrue(obj.doesGraphHasCycle(new Graph(vertices, edges)));
        v3.getEdgeList().remove(e4);
        Assert.assertFalse(obj.doesGraphHasCycle(new Graph(vertices, edges)));

    }

    public boolean doesGraphHasCycle(Graph g) {


        if (g != null && g.getVertices().size() != 0) {

            HashSet<Vertex> recurStack = new HashSet<Vertex>();
            HashSet<Vertex> visited = new HashSet<Vertex>();

            for (Vertex v : g.getVertices()) {
                if (doesGraphContainCycleUtil(v, recurStack, visited)) {
                    return true;
                }
            }
        }

        return false;


    }


    private boolean doesGraphContainCycleUtil(Vertex v, HashSet<Vertex> recurStack, HashSet<Vertex> visited) {

        if (!visited.contains(v)) {
            visited.add(v);
            recurStack.add(v);


            for (Edge e : v.getEdgeList()) {

                if (recurStack.contains(e.getDestination())) {
                    return true;
                } else if (doesGraphContainCycleUtil(e.getDestination(), recurStack, visited)) {
                    return true;
                }

            }

        }

        recurStack.remove(v);
        return false;

    }
}
