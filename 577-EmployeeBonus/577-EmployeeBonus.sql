-- Last updated: 7/16/2026, 4:11:50 PM
# Write your MySQL query statement below
SELECT 
    e.name, 
    b.bonus
FROM 
    Employee AS e
LEFT JOIN 
    Bonus AS b ON e.empId = b.empId
WHERE 
    b.bonus < 1000 
    OR b.bonus IS NULL;