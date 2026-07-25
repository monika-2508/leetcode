-- Last updated: 7/25/2026, 9:15:50 AM
# Write your MySQL query statement below
SELECT 
    event_day AS day,
    emp_id,
    SUM(out_time - in_time) AS total_time
FROM 
    Employees
GROUP BY 
    event_day, 
    emp_id;