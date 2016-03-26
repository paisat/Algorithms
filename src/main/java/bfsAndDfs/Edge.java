package bfsAndDfs;

/**
 * Created by sarvothampai on 13/03/16.
 */
public class Edge {

    private Vertex source;
    private Vertex destination;


    public Edge(Vertex source,Vertex destination){
        this.source=source;
        this.destination=destination;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }
}
