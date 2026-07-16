-- Last updated: 7/16/2026, 4:12:51 PM
# Write your MySQL query statement below
SELECT 
    email AS Email
FROM 
    Person
GROUP BY 
    email
HAVING 
    COUNT(email) > 1;