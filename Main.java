import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Premier exemple
        Vertex v1 = new Vertex(0, 0, 1, "V1");
        Vertex v2 = new Vertex(0, 0, 2, "V2");
        Vertex v3 = new Vertex(0, 0, 3, "V3");
        Vertex v4 = new Vertex(0, 0, 4, "V4");
        Vertex v5 = new Vertex(0, 0, 5, "V5");
        Vertex v6 = new Vertex(0, 0, 6, "V6");

        List<Edge> edges1 = Arrays.asList(
                new Edge(1, v1, v2, 3),
                new Edge(2, v1, v3, 4),
                new Edge(3, v1, v4, 2),
                new Edge(4, v2, v3, 4),
                new Edge(5, v2, v5, 2),
                new Edge(6, v3, v5, 6),
                new Edge(7, v4, v5, 1),
                new Edge(8, v4, v6, 4),
                new Edge(9, v5, v6, 2)
        );

        Graph graph1 = new Graph(Arrays.asList(v1, v2, v3, v4, v5, v6), edges1);

        System.out.println("Premier exemple :");
        System.out.println("Arêtes du graphe :");
        graph1.afficherArêtes();

        DijkstraAlgorithm dijkstra1 = new DijkstraAlgorithm(graph1);

        System.out.println("\nÉtat initial :");
        dijkstra1.init(v1);
        dijkstra1.displayCurrentState();

        dijkstra1.execute(v1);

        System.out.println("\nÉtat final :");
        dijkstra1.displayCurrentState();

        List<Vertex> path1 = dijkstra1.getPath(v6);
        if (!path1.isEmpty()) {
            System.out.println("\nChemin le plus court de V1 à V6 :");
            for (Vertex v : path1) {
                System.out.print(v.getName() + " ");
            }
            System.out.println("\nDistance totale : " + dijkstra1.distanceD.get(v6));
        } else {
            System.out.println("\nAucun chemin trouvé de V1 à V6");
        }

        // Deuxième exemple
        Vertex v7 = new Vertex(0, 0, 1, "A");
        Vertex v8 = new Vertex(0, 0, 2, "B");
        Vertex v9 = new Vertex(0, 0, 3, "C");
        Vertex v10 = new Vertex(0, 0, 4, "D");
        Vertex v11 = new Vertex(0, 0, 5, "E");
        Vertex v12 = new Vertex(0, 0, 6, "F");

        List<Edge> edges2 = Arrays.asList(
                new Edge(1, v7, v9, 3),  // A -> C
                new Edge(2, v7, v12, 1), // A -> F
                new Edge(3, v8, v10, 3), // B -> D
                new Edge(4, v8, v11, 1), // B -> E
                new Edge(5, v9, v12, 1), // C -> F
                new Edge(6, v9, v8, 2),  // C -> B
                new Edge(7, v9, v11, 3), // C -> E
                new Edge(8, v10, v11, 1),// D -> E
                new Edge(9, v11, v12, 5) // E -> F
        );

        Graph graph2 = new Graph(Arrays.asList(v7, v8, v9, v10, v11, v12), edges2);

        System.out.println("\n\nDeuxième exemple :");
        System.out.println("Arêtes du graphe :");
        graph2.afficherArêtes();

        DijkstraAlgorithm dijkstra2 = new DijkstraAlgorithm(graph2);

        System.out.println("\nÉtat initial :");
        dijkstra2.init(v7);
        dijkstra2.displayCurrentState();

        dijkstra2.execute(v7);

        System.out.println("\nÉtat final :");
        dijkstra2.displayCurrentState();

        List<Vertex> path2 = dijkstra2.getPath(v10);
        if (!path2.isEmpty()) {
            System.out.println("\nChemin le plus court de A à D :");
            for (Vertex v : path2) {
                System.out.print(v.getName() + " ");
            }
            System.out.println("\nDistance totale : " + dijkstra2.distanceD.get(v10));
        } else {
            System.out.println("\nAucun chemin trouvé de A à D");
        }
    }
}
