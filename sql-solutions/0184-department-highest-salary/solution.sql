-- mysql
select d.name as 'Department', e.name as 'Employee', e.salary as 'Salary'
from employee e
inner join department d
on e.departmentid = d.id
where (e.departmentid, e.salary) in
(
    select e.departmentid, max(e.salary)
    from employee e
    group by e.departmentid
);