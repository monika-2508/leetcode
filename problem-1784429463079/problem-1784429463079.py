# Last updated: 7/19/2026, 8:21:03 AM
1class Solution(object):
2    def minimumGroups(self, words):
3        """
4        :type words: List[str]
5        :rtype: int
6        """
7        def min_rotation(s):
8            n=len(s)
9            if n<=1:
10                return s
11            ss=s+s
12            i,j,k = 0,1,0
13            while i<n and j<n and k<n:
14                if ss[i+k] == ss[j+k]:
15                    k+=1
16                    continue
17
18                if ss[i+k] > ss[j+k]:
19                    i=i+k+1
20                    if i<=j:
21                        i=j+1
22                else:
23                    j=j+k+1
24                    if j<=i:
25                        j = i + 1
26                k=0
27
28            start = min(i,j)
29            return ss[start:start+n]
30
31        groups = set()
32        for w in words:
33            even = w[::2]
34            odd = w[1::2]
35            key = (min_rotation(even),min_rotation(odd))
36            groups.add(key)
37
38        return len(groups)