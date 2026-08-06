// Last updated: 8/6/2026, 9:42:01 AM
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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        return buildBST(nums, 0, nums.length - 1);
19    }
20
21    private TreeNode buildBST(int[] nums, int left, int right) {
22        if (left > right) {
23            return null;
24        }
25
26        // Pick middle element to keep tree height-balanced
27        int mid = left + (right - left) / 2;
28        TreeNode node = new TreeNode(nums[mid]);
29
30        // Recursively build left and right subtrees
31        node.left = buildBST(nums, left, mid - 1);
32        node.right = buildBST(nums, mid + 1, right);
33
34        return node;
35    }
36}