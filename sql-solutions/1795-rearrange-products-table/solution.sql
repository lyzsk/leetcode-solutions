-- mysql
(select product_id, 'store1' as store, store1 as price
from products p1
where store1 is not null
group by product_id
order by store1)
union
(select product_id, 'store2' as store, store2 as price
from products p1
where store2 is not null
group by product_id
order by store2)
union
(select product_id, 'store3' as store, store3 as price
from products p1
where store3 is not null
group by product_id
order by store3)
