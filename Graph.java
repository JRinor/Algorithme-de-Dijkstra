import java.util.ArrayList;
import java.util.List;

public class Graph {
    protected final List<Vertex> vertexes;
    protected final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void afficherArêtes() {
        for (Edge e : edges) {
            System.out.println(e.getSource().getName() + " -- " + e.getWeight() + " --> " + e.getDestination().getName());
        }
    }

    public int getDistance(Vertex node, Vertex target) {
        for (Edge e : edges) {
            if ((e.getSource().equals(node) && e.getDestination().equals(target)) ||
                    (e.getSource().equals(target) && e.getDestination().equals(node))) {
                return e.getWeight();
            }
        }
        return Integer.MAX_VALUE;
    }

    public List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getSource().equals(node)) {
                neighbors.add(e.getDestination());
            } else if (e.getDestination().equals(node)) {
                neighbors.add(e.getSource());
            }
        }
        return neighbors;
    }
}
