-- Last updated: 7/16/2026, 4:10:44 PM
# Write your MySQL query statement below
SELECT 
    player_id, 
    MIN(event_date) AS first_login
FROM 
    Activity
GROUP BY 
    player_id;