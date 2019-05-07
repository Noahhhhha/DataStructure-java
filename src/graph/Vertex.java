package graph;

/**
 * 顶点类
 */
public class Vertex {
    public char label;
    public boolean wasVisited; //有无访问过

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}
