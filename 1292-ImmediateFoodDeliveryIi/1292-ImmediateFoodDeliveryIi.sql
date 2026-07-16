-- Last updated: 7/16/2026, 4:10:28 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
WITH FirstOrders AS (
    -- Step 1: Find the first order date for every customer
    SELECT 
        customer_id, 
        MIN(order_date) AS first_order_date
    FROM Delivery
    GROUP BY customer_id
)
SELECT 
    -- Step 3: Calculate the percentage of immediate orders
    ROUND(
        SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END) 
        * 100.0 / COUNT(*), 
        2
    ) AS immediate_percentage
FROM Delivery d
-- Step 2: Filter the main table to keep ONLY the first orders
JOIN FirstOrders f 
    ON d.customer_id = f.customer_id 
    AND d.order_date = f.first_order_date;