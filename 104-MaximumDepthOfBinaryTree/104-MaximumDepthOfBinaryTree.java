// Last updated: 7/16/2026, 4:13:21 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the tree is empty, depth is 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The overall depth is 1 (current node) + the maximum depth of its subtrees
        return Math.max(leftDepth, rightDepth) + 1;
    }
}