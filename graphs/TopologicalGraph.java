package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by vikasnaiyar on 09/10/18.
 */
public class TopologicalGraph {

    static  class Node {
        int value;
        boolean isVisited;
        public Node(int value) {
            this.value = value;
            this.isVisited = false;
        }
    }

    private int vertexCount;

    private List<LinkedList> adjacencyList;

    public TopologicalGraph(int vertexCount) {
        this.vertexCount = vertexCount;

        adjacencyList = new ArrayList<>(this.vertexCount);

        IntStream.range(0,vertexCount).forEach(i ->
            adjacencyList.add(new LinkedList<>())
        );
    }

    public void addEdge (int srcNode, int destinationNode) {
        this.adjacencyList.get(srcNode).add(destinationNode);
    }

    // A utility function to print the adjacency list
    // representation of graph
     void printGraph()
    {
        for(int v = 0; v < this.vertexCount; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            this.adjacencyList.get(v).stream().forEach( System.out::print);
            System.out.println("\n");
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        // create the graph given in above figure
        int V = 8;
        TopologicalGraph graph = new TopologicalGraph(V);
        graph.addEdge( 0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge( 2, 4);
        graph.addEdge( 3, 5);
        graph.addEdge( 4, 5);
        graph.addEdge( 5, 6);
        graph.addEdge( 4, 7);

        // print the adjacency list representation of
        // the above graph
        graph.printGraph();
    }

}
