-- mysql
select w1.id
from weather w1
left join weather w2
on datediff(w1.recorddate, w2.recorddate) = 1
where w1.temperature > w2.temperature