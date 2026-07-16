// Last updated: 7/16/2026, 4:11:07 PM
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        // If current node's value is smaller than 'low', 
        // then everything in the left subtree is also too small. Skip it.
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // If current node's value is larger than 'high', 
        // then everything in the right subtree is also too large. Skip it.
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        // If root.val is within the inclusive range [low, high],
        // count it and explore both subtrees.
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}