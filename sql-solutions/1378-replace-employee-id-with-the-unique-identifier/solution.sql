-- mysql
select unique_id, name
from employees e1
left join employeeuni e2
on e1.id = e2.id;