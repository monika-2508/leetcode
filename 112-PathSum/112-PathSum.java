// Last updated: 9/1/2026, 9:00:38 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> postorderTraversal(TreeNode root) {
6        List<Integer> result = new ArrayList<>();
7        dfs(root, result);
8        return result;
9    }
10
11    private void dfs(TreeNode node, List<Integer> result) {
12        if (node == null) return;
13
14        dfs(node.left, result);    // Left
15        dfs(node.right, result);   // Right
16        result.add(node.val);      // Root
17    }
18}