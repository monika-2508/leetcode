# Last updated: 7/16/2026, 4:14:04 PM
class Solution(object):
    def twoSum(self, nums, target):
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if nums[i]+nums[j]==target:
                    return [i,j]
        return []
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        