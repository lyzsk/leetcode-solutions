-- mysql
select t1.product_id, t1.year as first_year, t1.quantity, t1.price
from
(
    select *, rank() over (partition by s.product_id order by year) as rk
    from sales s
) as t1
where t1.rk = 1; 