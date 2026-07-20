-- Last updated: 7/20/2026, 11:25:55 PM
# Write your MySQL query statement below
SELECT 
    eu.unique_id, 
    e.name
FROM 
    Employees e
LEFT JOIN 
    EmployeeUNI eu ON e.id = eu.id;