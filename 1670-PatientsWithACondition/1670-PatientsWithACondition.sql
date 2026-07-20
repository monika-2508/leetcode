-- Last updated: 7/20/2026, 11:25:48 PM
# Write your MySQL query statement below
SELECT 
    patient_id, 
    patient_name, 
    conditions
FROM 
    Patients
WHERE 
    conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%';