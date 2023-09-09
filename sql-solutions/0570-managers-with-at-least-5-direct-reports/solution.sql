-- mysql
select e1.name
from employee e1
where e1.id in
(
    select e2.managerid
    from employee e2
    group by e2.managerid
    having count(e2.managerid) >= 5
)