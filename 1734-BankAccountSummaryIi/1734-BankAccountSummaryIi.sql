-- Last updated: 7/20/2026, 11:25:45 PM
# Write your MySQL query statement below
SELECT 
    u.name, 
    SUM(t.amount) AS balance
FROM 
    Users u
JOIN 
    Transactions t ON u.account = t.account
GROUP BY 
    u.account
HAVING 
    SUM(t.amount) > 10000;