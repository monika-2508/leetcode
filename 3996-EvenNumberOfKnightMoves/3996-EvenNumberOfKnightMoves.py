# Last updated: 9/15/2026, 9:18:56 AM
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