# Last updated: 7/20/2026, 11:25:32 PM
class Solution(object):
    def minimumGroups(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        def min_rotation(s):
            n=len(s)
            if n<=1:
                return s
            ss=s+s
            i,j,k = 0,1,0
            while i<n and j<n and k<n:
                if ss[i+k] == ss[j+k]:
                    k+=1
                    continue

                if ss[i+k] > ss[j+k]:
                    i=i+k+1
                    if i<=j:
                        i=j+1
                else:
                    j=j+k+1
                    if j<=i:
                        j = i + 1
                k=0

            start = min(i,j)
            return ss[start:start+n]

        groups = set()
        for w in words:
            even = w[::2]
            odd = w[1::2]
            key = (min_rotation(even),min_rotation(odd))
            groups.add(key)

        return len(groups)