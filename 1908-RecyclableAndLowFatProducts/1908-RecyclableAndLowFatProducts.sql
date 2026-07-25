-- Last updated: 7/25/2026, 9:15:48 AM
# Write your MySQL query statement below
SELECT 
    product_id
FROM 
    Products
WHERE 
    low_fats = 'Y' 
    AND recyclable = 'Y';