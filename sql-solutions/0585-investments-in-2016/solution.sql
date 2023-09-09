-- mysql
select round(sum(i.tiv_2016), 2) as tiv_2016
from (
    select distinct i1.pid, i1.tiv_2016
    from insurance i1, insurance i2
    where i1.pid != i2.pid and i1.tiv_2015 = i2.tiv_2015
) i
where i.pid in (
    select pid
    from insurance
    group by lat, lon
    having count(*) = 1
)