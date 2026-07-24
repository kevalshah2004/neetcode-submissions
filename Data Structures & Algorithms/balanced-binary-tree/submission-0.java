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

    private int f(TreeNode root, int[] ans){
        if(root == null) return 0;
        int left = 1 + f(root.left, ans);
        int right = 1 + f(root.right, ans);
        ans[0] = Math.max(ans[0], Math.abs(left - right));
        return Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        int ans[] = new int[1];
        int height = f(root, ans);
        return ans[0] <= 1;
    }
}
