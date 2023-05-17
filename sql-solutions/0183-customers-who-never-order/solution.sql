-- mysql
select c.name as 'Customers'
from customers c
where c.id
not in
(
    select o.customerid from orders o
)