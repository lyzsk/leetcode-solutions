-- mysql
select a.actor_id, a.director_id
from actordirector a
group by a.actor_id, a.director_id
having count(*) >= 3;