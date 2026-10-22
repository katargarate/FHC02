package UE05_BreadthFirstSearch.Queue;
import UE05_BreadthFirstSearch.Tree.TreeNode;

public class QueueNode {
    private TreeNode treeNode;
    private QueueNode next;

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

}
