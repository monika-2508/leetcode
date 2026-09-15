# Last updated: 9/15/2026, 9:20:08 AM
class Solution(object):
    def maxRatings(self,units):
        mins=[]
        seconds=[]
        for row in units:
            row.sort()
            mins.append(row[0])
            seconds.append(row[1] if len(row)> 1 else row[0])
        return sum(seconds)-min(seconds)+min(mins)
        