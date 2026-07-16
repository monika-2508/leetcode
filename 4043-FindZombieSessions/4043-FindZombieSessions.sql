-- Last updated: 7/16/2026, 4:09:15 PM
# Write your MySQL query statement below
WITH SessionMetrics AS (
    SELECT 
        session_id,
        user_id,
        -- 1. Calculate session duration in minutes
        TIMESTAMPDIFF(MINUTE, MIN(event_timestamp), MAX(event_timestamp)) AS session_duration_minutes,
        -- 2. Count specific event types
        SUM(CASE WHEN event_type = 'scroll' THEN 1 ELSE 0 END) AS scroll_count,
        SUM(CASE WHEN event_type = 'click' THEN 1 ELSE 0 END) AS click_count,
        SUM(CASE WHEN event_type = 'purchase' THEN 1 ELSE 0 END) AS purchase_count
    FROM app_events
    GROUP BY session_id, user_id
)
SELECT 
    session_id,
    user_id,
    session_duration_minutes,
    scroll_count
FROM SessionMetrics
WHERE session_duration_minutes > 30               -- More than 30 minutes
  AND scroll_count >= 5                            -- At least 5 scroll events
  AND (click_count / scroll_count) < 0.20          -- Click-to-scroll ratio less than 0.20
  AND purchase_count = 0                           -- No purchases made
ORDER BY 
    scroll_count DESC, 
    session_id ASC;


    