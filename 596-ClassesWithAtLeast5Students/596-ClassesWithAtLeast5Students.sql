-- Last updated: 7/16/2026, 4:11:41 PM
# Write your MySQL query statement below
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;