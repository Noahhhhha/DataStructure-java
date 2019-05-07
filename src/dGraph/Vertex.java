package dGraph;

/**
 * 顶点类
 */
public class Vertex {
    public String label;
    public boolean wasVisited; //有无访问过

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }
}
