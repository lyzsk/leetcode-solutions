-- mysql
select c.name
from customer c
where c.referee_id <> 2 or c.referee_id is null