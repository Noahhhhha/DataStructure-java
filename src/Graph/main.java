package Graph;
/**
 * 图
 */
public class main {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1); //AB边
        theGraph.addEdge(0, 2); //AC边
        theGraph.addEdge(0, 3); //AD边
        theGraph.addEdge(1, 3); //BD边
        theGraph.addEdge(3, 4); //DE边

        System.out.println("基于栈的深度遍历：");
        theGraph.dfs();
        System.out.println("基于栈的广度遍历：");
        theGraph.bfs();

    }
}
