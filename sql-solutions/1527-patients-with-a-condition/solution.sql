-- mysql
select patient_id, patient_name, conditions
from patients
where conditions like 'DIAB1%' 
OR conditions like '% DIAB1%'
order by patient_id;