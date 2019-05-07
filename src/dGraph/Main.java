package dGraph;

import dGraph.DGraph;

/**
 * 图
 */
public class Main {
    public static void main(String[] args) {
        DGraph theGraph = new DGraph();
        theGraph.addVertex("C1");
        theGraph.addVertex("C2");
        theGraph.addVertex("C3");
        theGraph.addVertex("C4");
        theGraph.addVertex("C5");
        theGraph.addVertex("C6");
        theGraph.addVertex("C7");
        theGraph.addVertex("C8");
        theGraph.addVertex("C9");
        theGraph.addVertex("C10");
        theGraph.addEdge(0, 2);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(1, 3);
        theGraph.addEdge(2, 3);
        theGraph.addEdge(1, 4);
        theGraph.addEdge(3, 5);
        theGraph.addEdge(4, 5);
        theGraph.addEdge(3, 6);
        theGraph.addEdge(8, 6);
        theGraph.addEdge(9, 7);
        theGraph.addEdge(7, 8);
        theGraph.addEdge(0, 9);

        theGraph.topo();
    }
}
