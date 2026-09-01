-- Last updated: 9/1/2026, 9:18:48 AM
# Write your MySQL query statement below
WITH RankedScores AS (
    SELECT 
        student_id,
        subject,
        score,
        ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date ASC) AS r_asc,
        ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date DESC) AS r_desc,
        COUNT(*) OVER (PARTITION BY student_id, subject) AS exam_count
    FROM Scores
)
SELECT 
    f.student_id,
    f.subject,
    f.score AS first_score,
    l.score AS latest_score
FROM RankedScores f
JOIN RankedScores l 
    ON f.student_id = l.student_id 
   AND f.subject = l.subject
WHERE f.r_asc = 1 
  AND l.r_desc = 1 
  AND f.exam_count >= 2
  AND l.score > f.score
ORDER BY student_id, subject;