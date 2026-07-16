-- Last updated: 7/16/2026, 4:09:22 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
WITH RECURSIVE OrgHierarchy AS (
    -- Base Case: Start with the CEO (manager_id IS NULL)
    SELECT 
        employee_id,
        employee_name,
        manager_id,
        salary,
        1 AS level,
        CAST(employee_id AS CHAR(1000)) AS path
    FROM Employees
    WHERE manager_id IS NULL

    UNION ALL

    -- Recursive Case: Find employees reporting to the current level
    SELECT 
        e.employee_id,
        e.employee_name,
        e.manager_id,
        e.salary,
        o.level + 1 AS level,
        CONCAT(o.path, ',', e.employee_id) AS path
    FROM Employees e
    JOIN OrgHierarchy o ON e.manager_id = o.employee_id
),
Rollups AS (
    -- Calculate team size and budget by checking if a manager's ID 
    -- exists anywhere within an employee's organizational path sequence.
    SELECT 
        mgr.employee_id,
        COUNT(emp.employee_id) - 1 AS team_size,
        SUM(emp.salary) AS budget
    FROM OrgHierarchy mgr
    JOIN OrgHierarchy emp ON FIND_IN_SET(mgr.employee_id, emp.path) > 0
    GROUP BY mgr.employee_id
)
SELECT 
    h.employee_id,
    h.employee_name,
    h.level,
    r.team_size,
    r.budget
FROM OrgHierarchy h
JOIN Rollups r ON h.employee_id = r.employee_id
ORDER BY 
    h.level ASC, 
    r.budget DESC, 
    h.employee_name ASC;


    