-- Last updated: 7/16/2026, 4:10:31 PM
# Write your MySQL query statement below
SELECT 
    u.user_id AS buyer_id, 
    u.join_date, 
    COUNT(o.order_id) AS orders_in_2019
FROM 
    Users u
LEFT JOIN 
    Orders o ON u.user_id = o.buyer_id AND YEAR(o.order_date) = 2019
GROUP BY 
    u.user_id, 
    u.join_date;