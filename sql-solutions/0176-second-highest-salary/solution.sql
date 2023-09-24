-- mysql
select ifnull
(
  (
    select distinct salary
    from employee
    order by salary desc
    limit 1 offset 1
  ), null
) as SecondHighestSalary;

-- mysql
select
(
  select distinct t.salary from
  (
    select dense_rank() over(order by e.salary desc) as rk, e.salary from employee e
  ) as t
  where t.rk = 2
) as SecondHighestSalary;