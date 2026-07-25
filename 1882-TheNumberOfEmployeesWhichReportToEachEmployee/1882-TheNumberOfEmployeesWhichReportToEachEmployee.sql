-- Last updated: 7/25/2026, 9:15:55 AM
# Write your MySQL query statement below
SELECT 
    m.employee_id,
    m.name,
    COUNT(e.employee_id) AS reports_count,
    ROUND(AVG(e.age)) AS average_age
FROM 
    Employees m
JOIN 
    Employees e 
ON 
    m.employee_id = e.reports_to
GROUP BY 
    m.employee_id, 
    m.name
ORDER BY 
    m.employee_id ASC;