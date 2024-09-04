import java.util.*;

public class DijkstraAlgorithm {
    protected final Graph graph;
    protected PriorityQueue<Vertex> open;
    protected Set<Vertex> closed;
    protected Map<Vertex, Integer> distanceD;
    protected Map<Vertex, Vertex> parent;

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
        this.open = new PriorityQueue<>(Comparator.comparingInt(v -> distanceD.getOrDefault(v, Integer.MAX_VALUE)));
        this.closed = new HashSet<>();
        this.distanceD = new HashMap<>();
        this.parent = new HashMap<>();
    }

    public void init(Vertex sourceNode) {
        open.clear();
        closed.clear();
        distanceD.clear();
        parent.clear();

        open.add(sourceNode);
        distanceD.put(sourceNode, 0);
        parent.put(sourceNode, null);

        for (Vertex v : graph.getVertexes()) {
            if (!v.equals(sourceNode)) {
                distanceD.put(v, Integer.MAX_VALUE);
                parent.put(v, null);
            }
        }
    }

    public void displayCurrentState() {
        System.out.println("L'ensemble Open = " + open);
        System.out.println("L'ensemble Closed = " + closed);
        System.out.print("Taille distance [");
        for (Vertex v : graph.getVertexes()) {
            System.out.print(v.getName() + "=" + (distanceD.get(v) == Integer.MAX_VALUE ? "infinie" : distanceD.get(v)) + ", ");
        }
        System.out.println("]");
        System.out.print("Taille parent [");
        for (Vertex v : graph.getVertexes()) {
            System.out.print(v.getName() + "=" + (parent.get(v) == null ? "null" : parent.get(v).getName()) + ", ");
        }
        System.out.println("]");
    }

    public List<Vertex> getNeighbors(Vertex node) {
        return graph.getNeighbors(node).stream()
                .filter(v -> !closed.contains(v))
                .toList();
    }

    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = target;
        if (parent.get(step) == null) {
            return path;
        }
        path.add(step);
        while (parent.get(step) != null) {
            step = parent.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

    public void execute(Vertex sourceNode) {
        init(sourceNode);
        while (!open.isEmpty()) {
            Vertex current = open.poll();
            closed.add(current);

            List<Vertex> adja = getNeighbors(current);
            for (Vertex v : adja) {
                int newDistance = distanceD.get(current) + graph.getDistance(current, v);
                if (distanceD.get(v) > newDistance) {
                    distanceD.put(v, newDistance);
                    open.remove(v);
                    open.add(v);
                    parent.put(v, current);
                }
            }
        }
    }
}
