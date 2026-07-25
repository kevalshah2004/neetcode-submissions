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

    private void f(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(",#");
            return;
        }

        sb.append(",").append(root.val);
        f(root.left, sb);
        f(root.right, sb);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder tree = new StringBuilder();
        StringBuilder subtree = new StringBuilder();

        f(root, tree);
        f(subRoot, subtree);

        return tree.toString().contains(subtree.toString());
    }
}
