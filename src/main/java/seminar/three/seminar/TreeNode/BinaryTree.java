package seminar.three.seminar.TreeNode;

public class BinaryTree {

    Node root;

    /**
     * Create a recursive function that takes a node and the two values n1 and n2.
     */
    public Node lowestCommonAncestor(Node node, int n1, int n2){

        if(node == null) return null;

     /* If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree.
     Call the recursive function for the right subtree.
     * */
        if(node.value < n1 && node.value < n2) return lowestCommonAncestor(node.right,n1,n2);
    /* If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree.
     Call the recursive function for the left subtree.
    * */
        if(node.value > n1 && node.value > n2) return lowestCommonAncestor(node.left,n1,n2);
    /* If both the above cases are false then return the current node as LCA.
    * */
        return node;
    }

    /* Function to find LCA of n1 and n2.
    The function assumes that both
    n1 and n2 are present in BST */
    public Node lca(Node root, int n1, int n2){

        while (root != null){
            if(root.value < n1 && root.value < n2) root = root.right;
            else if(root.value > n1 && root.value > n2) root = root.left;
            else break;
        }
        return root;
    }
}
