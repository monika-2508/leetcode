# Last updated: 9/1/2026, 9:18:07 AM
class Solution(object):
    def countTasks(self, tasks, shifts):
        """
        :type tasks: List[int]
        :type shifts: List[int]
        :rtype: List[int]
        """
        n=len(tasks)
        prefix=[0]
        for t in tasks:
            prefix.append(prefix[-1]+t)


        total=prefix[-1]
        done=0
        ans=[]
        for s in shifts:
            target=done+s
            if target>=total:
                ans.append(0)
                done=0
            else:
                done=target
             
                completed=bisect_right(prefix,done)-1
                ans.append(n-completed)
        return ans