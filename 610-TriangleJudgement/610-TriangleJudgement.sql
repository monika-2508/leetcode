-- Last updated: 7/16/2026, 4:11:32 PM
# Write your MySQL query statement below
SELECT 
    x, y, z,
    CASE 
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM 
    Triangle;