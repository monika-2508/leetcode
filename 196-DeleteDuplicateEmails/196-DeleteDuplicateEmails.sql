-- Last updated: 7/16/2026, 4:12:42 PM
# Write your MySQL query statement below
DELETE p1 
FROM Person p1
INNER JOIN Person p2 
    ON p1.email = p2.email
WHERE p1.id > p2.id;