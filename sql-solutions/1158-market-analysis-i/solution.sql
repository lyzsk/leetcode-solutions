-- mysql
select u.user_id as buyer_id, u.join_date, 
ifnull(userbuy.cnt, 0) as orders_in_2019
from users u
left join
(
    select o.buyer_id, count(o.order_id) as cnt
    from orders o
    where o.order_date between '2019-01-01' and '2019-12-31'
    group by o.buyer_id
) as userbuy
on u.user_id = userbuy.buyer_id;