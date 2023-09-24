-- mysql
select s.score, 
(
    dense_rank() over(order by s.score desc)
) as 'rank'
from scores s;