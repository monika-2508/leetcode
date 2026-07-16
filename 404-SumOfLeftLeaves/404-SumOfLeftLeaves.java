// Last updated: 7/16/2026, 4:12:05 PM
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
         if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
             sum += sumOfLeftLeaves(root.left);
        }
        
        // Always recursively search the right subtree for any potential left leaves
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}