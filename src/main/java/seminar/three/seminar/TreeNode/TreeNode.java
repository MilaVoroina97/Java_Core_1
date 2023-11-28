package seminar.three.seminar.TreeNode;

/**
 * Найти ближайшего общего предка двух узлов дерева.
 * Ограничение по памяти: O(1)
 */
public class TreeNode {

    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode parent, TreeNode left, TreeNode right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public TreeNode lowestCommonAncestor(TreeNode first, TreeNode second) {

        int firstDepth = getDepth(first);
        int secondDepth = getDepth(second);
        return null;
    }

    private int getDepth(TreeNode treeNode){
        int depth = 0;
        while(treeNode != null){
            treeNode = treeNode.parent;
            depth++;
        }
        return depth;
    }
}
