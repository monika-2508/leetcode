-- Last updated: 7/16/2026, 4:11:52 PM
# Write your MySQL query statement below
SELECT name 
FROM Employee 
WHERE id IN (
    SELECT managerId 
    FROM Employee 
    GROUP BY managerId 
    HAVING COUNT(id) >= 5
);