-- Last updated: 7/16/2026, 4:11:29 PM
# Write your MySQL query statement below
SELECT id, movie, description, rating
FROM Cinema
WHERE id % 2 != 0 AND description <> 'boring'
ORDER BY rating DESC;