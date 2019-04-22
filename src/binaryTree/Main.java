package binaryTree;

public class Main {
    public static void main(String[] args) {
        BinTree tree = new BinTree("A B ^ D ^ ^ C ^ ^");

        System.out.println("深度为"+tree.Depth(tree.root)+"！");
        System.out.println("叶子节点共有"+tree.LeafCount(tree.root)+"个！");
        System.out.println("---------------先序------------------");
        tree.PreOrderTraverse(tree.root);
        System.out.println("---------------先序(非递归)------------------");
        tree.PreOrderTraverseByStack(tree.root);
        System.out.println("---------------中序------------------");
        tree.InOrderTraverse(tree.root);
        System.out.println("---------------后序------------------");
        tree.PostOrderTraverse(tree.root);
    }
}
