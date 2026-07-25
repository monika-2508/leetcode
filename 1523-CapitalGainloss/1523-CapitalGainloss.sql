-- Last updated: 7/25/2026, 9:16:28 AM
# Write your MySQL query statement below
SELECT 
    stock_name,
    SUM(
        CASE 
            WHEN operation = 'Sell' THEN price 
            ELSE -price 
        END
    ) AS capital_gain_loss
FROM 
    Stocks
GROUP BY 
    stock_name;