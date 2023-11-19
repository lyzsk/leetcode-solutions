-- mysql
select q1.person_name
from queue q1
where (
    select sum(weight)
    from queue q2
    where q1.turn >= q2.turn
) <= 1000
order by turn desc
limit 1;
