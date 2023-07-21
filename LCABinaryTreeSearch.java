public class LCABinaryTreeSearch {

    public static void main(String[] args) {
        int[] root = {6,2,8,0,4,7,9, Integer.parseInt(null), Integer.parseInt(null), 3,5};
        int p = 2, q = 8;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)   // because node value is greater than both values, check left side for LCA
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)   // if node value is less than both, check the right side
            return lowestCommonAncestor(root.right, p, q);
        return root;    // if node value is in between p and q, that must mean it is the LCA because of how a binary tree works, i.e. left side smaller than root and right side greater than root
    }                   // can also apply if one node value is the same as p/q value, as the LCA can also be a descendant of itself

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */




