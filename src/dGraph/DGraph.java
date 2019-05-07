package dGraph;

import com.sun.rowset.internal.Row;
import dGraph.Vertex;

/**
 * 图类
 */
public class DGraph {

    private static final int MAX_VERT = 20;

    private Vertex[] vertexList; //顶点数组

    private int adjMat[][]; //邻接数组

    private int nVerts; //当前顶点数量

    private String[] sortedArray; //输出用的数组

    public DGraph() {
        vertexList = new Vertex[MAX_VERT];
        adjMat = new int[MAX_VERT][MAX_VERT];
        sortedArray = new String[MAX_VERT];
        nVerts = 0;
    }

    //添加顶点
    public void addVertex(String label){
        vertexList[nVerts++] = new Vertex(label);
    }

    //添加边 (有向图添加法)
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
    }

    //展示点的label标签值
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    //拓扑排序 有向无环图
    public void topo(){
        int orig_nVerts = nVerts;
        while (nVerts > 0){
            int currentVertex = noSuccessors();
            if (currentVertex == -1){
                System.out.println("Error:Graph has cycles");
                return; //推出方法
            }
            sortedArray[nVerts - 1] = vertexList[currentVertex].label;
            //从图中删除顶点
            deleteVertex(currentVertex);
        }

        System.out.println("拓扑排序结果：");
        for (int j = 0; j < orig_nVerts; j++)
            System.out.println(sortedArray[j]);
        System.out.println(" ");
    }

    //查找图中没有后继顶点的顶点
    private int noSuccessors(){
        boolean isEdge;
        for (int row = 0; row < nVerts; row++){
            isEdge = false;
            for (int col = 0; col < nVerts; col++){
                if (adjMat[row][col] > 0){
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge)
                return row;
        }
        return -1;
    }

    //删除没有后继顶点的顶点
    public void deleteVertex(int delVert){
        if (delVert != nVerts - 1){
            //顶点数组后面的向前移
            for (int j = delVert; j < nVerts; j++) vertexList[j] = vertexList[j + 1];

            //邻接矩阵后面的行向上移动
            for (int row = delVert; row < nVerts - 1; row++) moveRowUp(row, nVerts);

            //邻接矩阵后面的列向左移动
            for (int col = delVert; col < nVerts - 1; col++) moveColLeft(col, nVerts - 1);
        }
        nVerts--;
    }

    //后面的行向上移动
    private void moveRowUp(int row, int length){
        for (int col = 0; col < length; col++)
            adjMat[row][col] =adjMat[row + 1][col];
    }

    //后面的列向左移动
    private void moveColLeft(int col, int length){
        for (int row = 0; row < length; row++){
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}
