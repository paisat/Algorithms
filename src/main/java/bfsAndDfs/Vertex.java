package bfsAndDfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarvothampai on 13/03/16.
 */
public class Vertex {

    private String vertexName;
    private List<Edge> edgeList;

    public Vertex(String name) {
        this.vertexName = name;
        edgeList = new ArrayList<Edge>();
    }

    public void addEdge(Edge e) {
        edgeList.add(e);
    }



    public List<Edge> getEdgeList() {
        return this.edgeList;
    }

    public String getVertexName() {
        return vertexName;
    }
}
