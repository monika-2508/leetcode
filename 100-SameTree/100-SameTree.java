// Last updated: 9/1/2026, 9:27:42 AM
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: Both nodes are null -> identical
        if (p == null && q == null) {
            return true;
        }

        // Base case: One node is null or values differ -> not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively compare left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}