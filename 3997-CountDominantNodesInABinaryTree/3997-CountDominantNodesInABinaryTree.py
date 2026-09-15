# Last updated: 9/15/2026, 9:18:54 AM
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def countDominantNodes(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        self.ans  = 0
        def dfs(node):
            if not node:
                return float('-inf')
            left_max = dfs(node.left)
            right_max = dfs(node.right)
            mx = max(node.val,left_max,right_max)
            if node.val == mx:
                self.ans+=1
            return mx
        dfs(root)
        return self.ans