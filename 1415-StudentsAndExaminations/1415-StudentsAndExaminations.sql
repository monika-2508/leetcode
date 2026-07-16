-- Last updated: 7/16/2026, 4:10:16 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT 
    s.student_id,
    s.student_name,
    sub.subject_name,
    -- Count the actual matches from the Examinations table
    COUNT(e.subject_name) AS attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN Examinations e 
    ON s.student_id = e.student_id 
    AND sub.subject_name = e.subject_name
GROUP BY 
    s.student_id, 
    s.student_name, 
    sub.subject_name
ORDER BY 
    s.student_id ASC, 
    sub.subject_name ASC;