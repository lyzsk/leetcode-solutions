-- mysql
select
  ifnull(
    (select distinct e.salary
    from employee e
    order by e.salary desc
    limit 1 offset 1)
  , null)
as SecondHighestSalary;