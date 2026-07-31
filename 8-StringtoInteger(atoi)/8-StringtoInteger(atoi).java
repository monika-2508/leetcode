// Last updated: 7/31/2026, 9:16:38 AM
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
17    public boolean isBalanced(TreeNode root) {
18        return checkHeight(root) != -1;
19    }
20
21    private int checkHeight(TreeNode node) {
22        if (node == null) {
23            return 0;
24        }
25
26        // Check left subtree
27        int leftHeight = checkHeight(node.left);
28        if (leftHeight == -1) {
29            return -1; // Left subtree is unbalanced
30        }
31
32        // Check right subtree
33        int rightHeight = checkHeight(node.right);
34        if (rightHeight == -1) {
35            return -1; // Right subtree is unbalanced
36        }
37
38        // If height difference between left and right subtrees > 1, unbalanced
39        if (Math.abs(leftHeight - rightHeight) > 1) {
40            return -1;
41        }
42
43        // Return actual height of current node
44        return Math.max(leftHeight, rightHeight) + 1;
45    }
46}