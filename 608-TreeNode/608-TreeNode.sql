-- Last updated: 7/16/2026, 4:11:33 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT 
    id,
    CASE 
        -- Rule 1: If it has no parent, it's the Root
        WHEN p_id IS NULL THEN 'Root'
        
        -- Rule 2: If its ID appears in the p_id column of the table, 
        -- it means it has children, making it an Inner node
        WHEN id IN (SELECT DISTINCT p_id FROM Tree WHERE p_id IS NOT NULL) THEN 'Inner'
        
        -- Rule 3: Otherwise, it has a parent but no children, making it a Leaf
        ELSE 'Leaf'
    END AS type
FROM Tree;