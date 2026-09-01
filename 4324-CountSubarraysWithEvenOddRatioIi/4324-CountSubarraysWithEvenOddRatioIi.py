# Last updated: 9/1/2026, 9:17:48 AM
class Solution(object):
    def countRatioSubarrays(self, nums, a, b):
        """
        :type nums: List[int]
        :type a: int
        :type b: int
        :rtype: int
        """
        n=len(nums)
        pref = [0]*(n+1)
        for i in range(n):
            if nums[i]%2==0:
                pref[i+1]=pref[i]+b
            else:
                pref[i+1]  = pref[i]-a
        vals = sorted(set(pref))
        rank={v:i+1 for i,v in enumerate(vals)}
        m=len(vals)
        bit=[0]*(m+1)
        def update(idx):
            while idx <=m:
                bit[idx]+=1
                idx+=idx & -idx
        def query(idx):
            res=0
            while idx>0:
                res+=bit[idx]
                idx-=idx&-idx
            return res
        ans=0
        for i,x in enumerate(pref):
            r=rank[x]
            seen=i
            smaller=query(r-1)
            ans+=seen-smaller
            update(r)
        return ans