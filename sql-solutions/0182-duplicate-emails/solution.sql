-- mysql
select p.email as 'Email'
from person p
group by p.email
having count(p.email) > 1