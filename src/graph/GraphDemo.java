package graph;

import java.util.LinkedList;

class Graph {
    int vertices;
    LinkedList<Integer> adjacencyList[];

    Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for(int i=0;i<vertices;i++)
            adjacencyList[i] = new LinkedList<>();
    }
}

public class GraphDemo {

    public static void main(String []args){
        int vertices =5;
        Graph graph = new Graph(vertices);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);

    }

    private static void printGraph(Graph graph) {

        for(int v=0;v<graph.vertices;v++){
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer node:graph.adjacencyList[v]){
                System.out.print(" -> "+node);
            }
            System.out.println("\n");
        }
    }

    private static void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src to dest.
        graph.adjacencyList[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        graph.adjacencyList[dest].add(src);

    }
}
