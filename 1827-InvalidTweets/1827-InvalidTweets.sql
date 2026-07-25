-- Last updated: 7/25/2026, 9:15:59 AM
# Write your MySQL query statement below
SELECT 
    tweet_id
FROM 
    Tweets
WHERE 
    LENGTH(content) > 15;