-- Last updated: 7/25/2026, 9:15:43 AM
# Write your MySQL query statement below
SELECT 
    employee_id,
    IF(employee_id % 2 != 0 AND name NOT LIKE 'M%', salary, 0) AS bonus
FROM 
    Employees
ORDER BY 
    employee_id ASC;