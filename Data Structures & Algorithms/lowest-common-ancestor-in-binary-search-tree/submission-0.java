/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        if(root == p || root == q) return root;
        
        TreeNode left = f(root.left, p, q);
        TreeNode right = f(root.right, p, q);

        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        return right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;  // Both nodes are in the left subtree
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right; // Both nodes are in the right subtree
            } else {
                return root;       // We found the split point!
            }
        }
        return null;
    }
}
