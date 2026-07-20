-- Last updated: 7/20/2026, 11:25:46 PM
# Write your MySQL query statement below
SELECT 
    v.customer_id, 
    COUNT(v.visit_id) AS count_no_trans
FROM 
    Visits v
LEFT JOIN 
    Transactions t ON v.visit_id = t.visit_id
WHERE 
    t.transaction_id IS NULL
GROUP BY 
    v.customer_id;