package bfsAndDfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarvothampai on 13/03/16.
 * <p/>
 * <p/>
 * Topological sort can only be applied to a DAG
 */
public class TopologicalSorting {


    @Test
    public void test() {


        TopologicalSorting obj = new TopologicalSorting();
        List<Vertex> vertices = new ArrayList<Vertex>();
        List<Edge> edges = new ArrayList<Edge>();

        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);


        Edge v5_0 = new Edge(v5, v0);
        Edge v5_2 = new Edge(v5, v2);
        Edge v4_0 = new Edge(v4, v0);
        Edge v4_1 = new Edge(v4, v1);

        Edge v2_3 = new Edge(v2, v3);
        Edge v3_1 = new Edge(v3, v1);

        edges.add(v5_0);
        edges.add(v5_2);
        edges.add(v4_0);
        edges.add(v4_1);
        edges.add(v2_3);
        edges.add(v3_1);

        v5.addEdge(v5_0);
        v5.addEdge(v5_2);
        v4.addEdge(v4_0);
        v4.addEdge(v4_1);
        v2.addEdge(v2_3);
        v3.addEdge(v3_1);


        List<String> expected = new ArrayList<String>();
        expected.add("5");
        expected.add("4");
        expected.add("2");
        expected.add("3");
        expected.add("1");
        expected.add("0");

        List<String> actual = obj.topologicalSort(new Graph(vertices, edges));
        Assert.assertEquals(expected.size(), actual.size());

        for (int i = 0; i < actual.size(); i++) {
            String e = expected.get(i);
            String a = actual.get(i);
            Assert.assertEquals(e, a);
        }

    }

    @Test
    public void testWithGraphContainingCycle() {

        TopologicalSorting obj = new TopologicalSorting();

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

        List<String> actual=obj.topologicalSort(new Graph(vertices,edges));
        Assert.assertEquals(0,actual.size());

    }

    public List<String> topologicalSort(Graph g) {

        List<String> result = new ArrayList<String>();

        HashSet<Vertex> visited = new HashSet<Vertex>();
        HashSet<Vertex> recursion = new HashSet<Vertex>();
        Stack<Vertex> topo = new Stack<Vertex>();
        boolean[] loopFound = new boolean[1];


        if (g != null && g.getVertices().size() != 0) {

            for (Vertex v : g.getVertices()) {
                if (!visited.contains(v)) {
                    topologicalSortUtil(v, visited, recursion, topo, loopFound);
                }

            }

            if (!loopFound[0]) {

                while (!topo.isEmpty()) {
                    result.add(topo.pop().getVertexName());
                }

            }

        }

        return result;
    }


    private void topologicalSortUtil(Vertex v, HashSet<Vertex> visited, HashSet<Vertex> recursion, Stack<Vertex> topo, boolean[] loopFound) {

        visited.add(v);
        recursion.add(v);

        for (Edge e : v.getEdgeList()) {

            if (!loopFound[0]) {

                if (recursion.contains(e.getDestination())) {
                    loopFound[0] = true;
                } else if (!visited.contains(e.getDestination())) {
                    topologicalSortUtil(e.getDestination(), visited, recursion, topo, loopFound);
                }

            }

        }

        recursion.remove(v);
        topo.add(v);
    }
}
