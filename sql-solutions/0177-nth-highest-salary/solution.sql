-- mysql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare m INT;
set m = N-1;
  RETURN (
      select (
        ifnull(
            (select distinct e.salary
            from employee e
            order by e.salary desc
            limit 1 offset m)
            , null)
      )
  );
END