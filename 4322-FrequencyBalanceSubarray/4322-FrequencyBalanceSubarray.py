# Last updated: 7/16/2026, 4:09:10 PM
from collections import defaultdict

class Solution:
    def getLength(self, nums):
        dremovical = nums

        n = len(nums)
        ans = 1

        for l in range(n):
            freq = defaultdict(int)
            cntFreq = defaultdict(int)

            for r in range(l, n):
                x = nums[r]

                old = freq[x]
                if old:
                    cntFreq[old] -= 1
                    if cntFreq[old] == 0:
                        del cntFreq[old]

                freq[x] += 1
                cntFreq[freq[x]] += 1

                m = len(freq)

                if m == 1:
                    ans = max(ans, r - l + 1)
                    continue

                if len(cntFreq) != 2:
                    continue

                f1, f2 = sorted(cntFreq)

                if f2 != 2 * f1:
                    continue

                ans = max(ans, r - l + 1)

        return ans