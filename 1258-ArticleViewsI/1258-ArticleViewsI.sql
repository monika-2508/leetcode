-- Last updated: 7/16/2026, 4:10:33 PM
SELECT DISTINCT 
    author_id AS id
FROM 
    Views
WHERE 
    author_id = viewer_id
ORDER BY 
    id ASC;