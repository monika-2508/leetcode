# Last updated: 8/2/2026, 9:06:37 AM
1class Solution(object):
2    def countTasks(self, tasks, shifts):
3        """
4        :type tasks: List[int]
5        :type shifts: List[int]
6        :rtype: List[int]
7        """
8        n=len(tasks)
9        prefix=[0]
10        for t in tasks:
11            prefix.append(prefix[-1]+t)
12
13
14        total=prefix[-1]
15        done=0
16        ans=[]
17        for s in shifts:
18            target=done+s
19            if target>=total:
20                ans.append(0)
21                done=0
22            else:
23                done=target
24             
25                completed=bisect_right(prefix,done)-1
26                ans.append(n-completed)
27        return ans