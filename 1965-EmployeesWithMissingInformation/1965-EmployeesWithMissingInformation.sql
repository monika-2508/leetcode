-- Last updated: 9/15/2026, 9:22:36 AM
# Write your MySQL query statement below
SELECT 
    employee_id
FROM (
    SELECT employee_id FROM Employees
    UNION ALL
    SELECT employee_id FROM Salaries
) AS Combined
GROUP BY 
    employee_id
HAVING 
    COUNT(employee_id) = 1
ORDER BY 
    employee_id ASC;