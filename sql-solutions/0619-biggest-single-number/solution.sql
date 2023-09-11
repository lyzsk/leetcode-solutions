-- mysql
select if(count(num) = 1, num, null) as num
from mynumbers
group by num
order by count(num), num desc
limit 1