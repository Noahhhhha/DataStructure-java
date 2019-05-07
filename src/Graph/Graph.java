package Graph;

/**
 * 图类
 */
public class Graph {

    private static final int MAX_VERT = 20;

    private Vertex[] vertexList; //顶点数组

    private int adjMat[][]; //邻接数组

    private int nVerts; //当前顶点数量

    private StackX theStack; //深度优先搜索用的栈

    private Queue theQueue; //广度优先搜索用的栈

    public Graph() {
        vertexList = new Vertex[MAX_VERT];
        adjMat = new int[MAX_VERT][MAX_VERT];
        nVerts = 0;
        theStack = new StackX();
        theQueue = new Queue();
    }

    //添加顶点
    public void addVertex(char label){
        vertexList[nVerts++] = new Vertex(label);
    }

    //添加边 (无向图添加法)
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //展示点的label标签值
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    //深度优先访问
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()){
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else{
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j=0; j<nVerts; j++)
            vertexList[j].wasVisited = false;
    }

    //广度优先搜索
    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2; //临时变量
        while (!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            while ((v2=getAdjUnvisitedVertex(v1)) != -1){ //将一行的所有列访问完
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int j=0; j<nVerts; j++)
            vertexList[j].wasVisited = false;
    }

    //最小生成树
    public void mst(){
        vertexList[0].wasVisited = true;
        theStack.push(0);
        while (!theStack.isEmpty()){
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                theStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.println(" ");
            }
        }
        for (int j=0; j<nVerts; j++)
            vertexList[j].wasVisited = false;
    }


    //获取指定顶点相邻接的一个未被访问过的顶点
    private int getAdjUnvisitedVertex(int v){
        for(int j=0; j<nVerts; j++)
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j; //找到了一个与v顶点相邻接的未访问的顶点位置
        return -1; //未找到
    }
}
