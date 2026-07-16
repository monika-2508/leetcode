-- Last updated: 7/16/2026, 4:12:59 PM
# Write your MySQL query statement below
SELECT 
    score, 
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM 
    Scores;