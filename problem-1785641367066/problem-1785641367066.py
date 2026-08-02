# Last updated: 8/2/2026, 8:59:27 AM
1class Solution(object):
2    def countRatioSubarrays(self, nums, a, b):
3        """
4        :type nums: List[int]
5        :type a: int
6        :type b: int
7        :rtype: int
8        """
9        n=len(nums)
10        pref = [0]*(n+1)
11        for i in range(n):
12            if nums[i]%2==0:
13                pref[i+1]=pref[i]+b
14            else:
15                pref[i+1]  = pref[i]-a
16        vals = sorted(set(pref))
17        rank={v:i+1 for i,v in enumerate(vals)}
18        m=len(vals)
19        bit=[0]*(m+1)
20        def update(idx):
21            while idx <=m:
22                bit[idx]+=1
23                idx+=idx & -idx
24        def query(idx):
25            res=0
26            while idx>0:
27                res+=bit[idx]
28                idx-=idx&-idx
29            return res
30        ans=0
31        for i,x in enumerate(pref):
32            r=rank[x]
33            seen=i
34            smaller=query(r-1)
35            ans+=seen-smaller
36            update(r)
37        return ans