# Last updated: 7/19/2026, 8:09:10 AM
1class Solution(object):
2    def canReach(self, start, target):
3        """
4        :type start: List[int]
5        :type target: List[int]
6        :rtype: bool
7        """
8        if start == target:
9            return True
10        return ((start[0]+start[1]) &1) == ((target[0]+target[1])&1)