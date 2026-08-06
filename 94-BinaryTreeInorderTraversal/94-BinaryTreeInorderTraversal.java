// Last updated: 8/6/2026, 9:43:25 AM
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> result = new ArrayList<>();
19        Stack<TreeNode> stack = new Stack<>();
20        TreeNode current = root;
21
22        while (current != null || !stack.isEmpty()) {
23            // Reach the leftmost node of the current node
24            while (current != null) {
25                stack.push(current);
26                current = current.left;
27            }
28
29            // Current must be null at this point
30            current = stack.pop();
31            result.add(current.val);
32
33            // We have visited the node and its left subtree. Now, it's the right subtree's turn
34            current = current.right;
35        }
36
37        return result;
38    }
39}