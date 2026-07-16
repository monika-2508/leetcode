-- Last updated: 7/16/2026, 4:11:45 PM
# Write your MySQL query statement below
SELECT 
    customer_number
FROM 
    Orders
GROUP BY 
    customer_number
ORDER BY 
    COUNT(order_number) DESC
LIMIT 1;