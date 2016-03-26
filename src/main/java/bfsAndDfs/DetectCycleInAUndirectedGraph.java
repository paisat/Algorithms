package bfsAndDfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 13/03/16.
 * <p/>
 * Detect cycle in an undirected graph
 * <p/>
 * DFS
 */
public class DetectCycleInAUndirectedGraph {


    @Test
    public void test() {


        DetectCycleInAUndirectedGraph obj = new DetectCycleInAUndirectedGraph();

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

        Edge e1_ = new Edge(v2, v1);
        edges.add(e1_);

        Edge e2 = new Edge(v2, v3);
        Edge e2_ = new Edge(v3, v2);
        Edge e3 = new Edge(v2, v4);
        Edge e3_ = new Edge(v4, v2);
        edges.add(e2);
        edges.add(e2_);
        edges.add(e3);
        edges.add(e3_);

        Edge e4 = new Edge(v3, v1);
        Edge e4_ = new Edge(v1, v3);
        edges.add(e4);
        edges.add(e4_);

        Edge e5 = new Edge(v4, v3);
        Edge e5_ = new Edge(v3, v4);
        edges.add(e5);
        edges.add(e5_);

        v1.addEdge(e1);
        v2.addEdge(e1_);
        v2.addEdge(e2);
        v3.addEdge(e2_);
        v3.addEdge(e4);
        v1.addEdge(e4_);
        v2.addEdge(e3);
        v4.addEdge(e3_);


        Assert.assertTrue(obj.doesGraphHasCycle(new Graph(vertices, edges)));
        v1.getEdgeList().remove(e4_);
        v3.getEdgeList().remove(e4);
        Assert.assertFalse(obj.doesGraphHasCycle(new Graph(vertices, edges)));


    }

    public boolean doesGraphHasCycle(Graph g) {


        if (g != null && g.getVertices().size() != 0) {

            HashSet<Vertex> visited = new HashSet<Vertex>();

            for (Vertex v : g.getVertices()) {

                if (doesGraphHasCycleUtil(v, null, visited)) {
                    return true;
                }
            }


        }

        return false;

    }


    private boolean doesGraphHasCycleUtil(Vertex v, Vertex parent, HashSet<Vertex> visited) {


        if (!visited.contains(v)) {

            visited.add(v);
            for (Edge e : v.getEdgeList()) {

                if (visited.contains(e.getDestination()) && e.getDestination() != parent) {
                    return true;
                } else if (doesGraphHasCycleUtil(e.getDestination(), v, visited)) {
                    return true;
                }
            }

        }

        return false;

    }

}
