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

    public int f(TreeNode root, int[] arr){
        if(root == null) return 0;
        int left = 1 + f(root.left, arr);
        int right = 1 + f(root.right, arr);
        arr[0] = Math.max(arr[0], left + right - 2);
        return Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int arr[] = new int[1];
        f(root, arr);
        return arr[0];
    }
}
