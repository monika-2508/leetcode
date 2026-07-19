# Last updated: 7/19/2026, 8:14:23 AM
1# Definition for a binary tree node.
2# class TreeNode(object):
3#     def __init__(self, val=0, left=None, right=None):
4#         self.val = val
5#         self.left = left
6#         self.right = right
7class Solution(object):
8    def countDominantNodes(self, root):
9        """
10        :type root: Optional[TreeNode]
11        :rtype: int
12        """
13        self.ans  = 0
14        def dfs(node):
15            if not node:
16                return float('-inf')
17            left_max = dfs(node.left)
18            right_max = dfs(node.right)
19            mx = max(node.val,left_max,right_max)
20            if node.val == mx:
21                self.ans+=1
22            return mx
23        dfs(root)
24        return self.ans