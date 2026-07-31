// Last updated: 7/31/2026, 9:11:20 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean isSameTree(TreeNode p, TreeNode q) {
18        // Base case: Both nodes are null -> identical
19        if (p == null && q == null) {
20            return true;
21        }
22
23        // Base case: One node is null or values differ -> not identical
24        if (p == null || q == null || p.val != q.val) {
25            return false;
26        }
27
28        // Recursively compare left and right subtrees
29        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
30    }
31}