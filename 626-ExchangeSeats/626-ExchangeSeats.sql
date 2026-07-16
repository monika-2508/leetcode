-- Last updated: 7/16/2026, 4:11:27 PM
# Write your MySQL query statement below
SELECT 
    CASE 
        -- If it's the last seat and the total count is odd, don't swap
        WHEN id = (SELECT COUNT(*) FROM Seat) AND id % 2 = 1 THEN id
        -- If the id is odd, swap with the next row (id + 1)
        WHEN id % 2 = 1 THEN id + 1
        -- If the id is even, swap with the previous row (id - 1)
        ELSE id - 1
    END AS id,
    student
FROM 
    Seat
ORDER BY 
    id ASC;