-- mysql
select users.name, sum(transactions.amount) as balance
from users
left join transactions
on users.account = transactions.account
group by users.name
having sum(transactions.amount) > 10000;