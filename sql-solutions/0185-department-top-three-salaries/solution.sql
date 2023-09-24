-- mysql
select d.name as Department, e.name as Employee, e.salary as Salary
from employee e
inner join department d
on e.departmentid = d.id
and (e.departmentid, e.name) in
(
    select departmentid, name from
    (
        select departmentid, name, 
        dense_rank() over(partition by departmentid order by salary desc) as rk
        from employee
    ) as t
    where t.rk <= 3
);

-- mysql
select d.name as Department, e.name as Employee, e.salary as Salary
from employee e
left join department d
on departmentid = d.id
where
(
    select count(distinct salary)
    from employee
    where departmentid = e.departmentid and salary >= e.salary
) <= 3;