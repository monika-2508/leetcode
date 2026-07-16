-- Last updated: 7/16/2026, 4:10:42 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
WITH FirstLogin AS (
    -- Step 1: Find the first login date for each player
    SELECT 
        player_id, 
        MIN(event_date) AS first_date
    FROM Activity
    GROUP BY player_id
)
SELECT 
    -- Step 3: Round the fraction to 2 decimal places
    ROUND(
        COUNT(DISTINCT a.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM FirstLogin f
-- Step 2: Inner join back to Activity to find matching consecutive logins
JOIN Activity a 
    ON f.player_id = a.player_id 
    AND a.event_date = DATE_ADD(f.first_date, INTERVAL 1 DAY);