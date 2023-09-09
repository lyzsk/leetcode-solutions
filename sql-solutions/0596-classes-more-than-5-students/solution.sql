-- mysql
select class
from courses
group by student
having count(*) >= 5