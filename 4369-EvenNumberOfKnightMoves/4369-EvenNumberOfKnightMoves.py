# Last updated: 7/20/2026, 11:25:21 PM
class Solution(object):
    def canReach(self, start, target):
        """
        :type start: List[int]
        :type target: List[int]
        :rtype: bool
        """
        if start == target:
            return True
        return ((start[0]+start[1]) &1) == ((target[0]+target[1])&1)