-- mysql
select e.name, b.bonus
from employee e
left join bonus b
on e.empid = b.empid
where b.bonus is null or b.bonus < 1000