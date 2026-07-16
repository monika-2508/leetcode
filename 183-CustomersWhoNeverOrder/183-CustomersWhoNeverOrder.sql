-- Last updated: 7/16/2026, 4:12:49 PM
# Write your MySQL query statement below
SELECT 
    c.name AS Customers
FROM 
    Customers c
LEFT JOIN 
    Orders o ON c.id = o.customerId
WHERE 
    o.id IS NULL;