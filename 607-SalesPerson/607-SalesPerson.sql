-- Last updated: 7/16/2026, 4:11:35 PM
# Write your MySQL query statement below
SELECT name
FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT o.sales_id
    FROM Orders o
    JOIN Company c ON o.com_id = c.com_id
    WHERE c.name = 'RED'
);