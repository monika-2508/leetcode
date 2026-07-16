-- Last updated: 7/16/2026, 4:11:39 PM
# Write your MySQL query statement below
WITH FilteredStadium AS (
    -- Step 1: Filter rows that meet the initial condition (people >= 100)
    SELECT 
        id, 
        visit_date, 
        people,
        -- Step 2: Create a grouping identifier for consecutive groups
        id - ROW_NUMBER() OVER (ORDER BY id) AS id_group
    FROM Stadium
    WHERE people >= 100
),
GroupCounts AS (
    -- Step 3: Count how many rows are in each consecutive group
    SELECT 
        id, 
        visit_date, 
        people,
        COUNT(*) OVER (PARTITION BY id_group) AS group_size
    FROM FilteredStadium
)
-- Step 4: Keep only the groups that have 3 or more rows
SELECT 
    id, 
    visit_date, 
    people
FROM GroupCounts
WHERE group_size >= 3
ORDER BY visit_date ASC;