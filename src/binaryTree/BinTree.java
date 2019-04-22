package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class BinTree {

    int index = 0;

    //定义一个根节点
    BinTreeNode root = new BinTreeNode();

    //得到的数据
    String[] datas;

    public void CreatBiTree (BinTreeNode treeNode)
    {
        treeNode.data = datas[index];
        index++;
        // 按输入的先序序列建立二叉链表 :AB^D^^C^^
        if(treeNode.data.equals("^"))
        {
            treeNode=null; //接收到^号代表当前构造的子树为空
        }
        else
        {
            treeNode.lchild = new BinTreeNode();
            treeNode.rchild = new BinTreeNode();
            CreatBiTree(treeNode.lchild);// 先序遍历建立左子树
            CreatBiTree(treeNode.rchild);// 先序遍历建立右子树
        }
    }

    //非递归先序遍历
    public void PreOrderTraverseByStack(BinTreeNode currentNode){
        Deque<BinTreeNode> stack = new LinkedList<BinTreeNode>();
        while (!currentNode.data.equals("^") || !stack.isEmpty()){
            while (!currentNode.data.equals("^")){
                    System.out.println(currentNode.data);
                    stack.push(currentNode);
                    currentNode = currentNode.lchild;
            }
            if (!stack.isEmpty()){
                currentNode = stack.pop();
                currentNode = currentNode.rchild;
            }
        }
    }

    //递归先序遍历
    public void PreOrderTraverse(BinTreeNode treeNode){
        if(datas.length!=0){
            if (!treeNode.data.equals("^")){
                System.out.println(treeNode.data);
                PreOrderTraverse(treeNode.lchild);
                PreOrderTraverse(treeNode.rchild);
            }
        }else{
            System.out.println("树为空");
        }
    }

    //递归中序遍历
    public void InOrderTraverse(BinTreeNode treeNode){
        if(datas.length!=0){
            if (!treeNode.data.equals("^")){
                InOrderTraverse(treeNode.lchild);
                System.out.println(treeNode.data);
                InOrderTraverse(treeNode.rchild);
            }
        }else{
            System.out.println("树为空");
        }
    }

    //递归后续遍历
    public void PostOrderTraverse(BinTreeNode treeNode){
        if(datas.length!=0){
            if (!treeNode.data.equals("^")){
                PostOrderTraverse(treeNode.lchild);
                PostOrderTraverse(treeNode.rchild);
                System.out.println(treeNode.data);
            }
        }else{
            System.out.println("树为空");
        }
    }

    //求二叉树的高度
    public int Depth(BinTreeNode treeNode){
        if(treeNode.data.equals("^"))	return 0;
        else return Depth(treeNode.lchild)>Depth(treeNode.rchild) ? Depth(treeNode.lchild)+1 : Depth(treeNode.rchild)+1;
    }

    //求二叉树叶子数
    public int LeafCount(BinTreeNode treeNode){
        if (treeNode.data.equals("^")) return 0;
        if (treeNode.lchild.data.equals("^") && treeNode.rchild.data.equals("^")) return 1;
        else return LeafCount(treeNode.lchild) + LeafCount(treeNode.rchild);
    }

    //构造方法
    public BinTree(String datas) {
        this.datas = datas.split(" ");
        CreatBiTree(root);
    }
}
