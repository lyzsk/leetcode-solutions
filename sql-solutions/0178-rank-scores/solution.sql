-- mysql
select a.score as score,
(select count(distinct b.score)
from scores b
where b.score >= a.score) as `rank`
from scores a
order by a.score desc
