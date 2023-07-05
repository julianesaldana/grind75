public class InvertBinaryTree {
    public static void main(String[] args) {
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            // using recursion, want to swap every leaves left and right
            invertTree(root.left);
            invertTree(root.right);

            // switching left and right leaves
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        return root;
    }
}



 // Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode() {
     }

     TreeNode(int val) {
         this.val = val;
     }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
