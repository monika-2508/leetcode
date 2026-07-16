-- Last updated: 7/16/2026, 4:10:29 PM
# Write your MySQL query statement below
-- Step 1: Find the latest price change on or before 2019-08-16
SELECT 
    product_id, 
    new_price AS price
FROM 
    Products
WHERE 
    (product_id, change_date) IN (
        SELECT 
            product_id, 
            MAX(change_date)
        FROM 
            Products
        WHERE 
            change_date <= '2019-08-16'
        GROUP BY 
            product_id
    )

UNION

-- Step 2: For products whose first price change happened AFTER 2019-08-16, set price to 10
SELECT 
    product_id, 
    10 AS price
FROM 
    Products
GROUP BY 
    product_id
HAVING 
    MIN(change_date) > '2019-08-16';