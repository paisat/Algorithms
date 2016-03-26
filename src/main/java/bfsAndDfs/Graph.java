package bfsAndDfs;

import java.util.List;

/**
 * Created by sarvothampai on 13/03/16.
 */
public class Graph {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertexList = vertices;
        this.edgeList = edges;
    }

    public List<Vertex> getVertices(){
        return this.vertexList;
    }

    public List<Edge> getEdgeList(){
        return this.edgeList;
    }

}
