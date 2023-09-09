-- mysql
select requester_id as id, cnt as num from
(
    select requester_id, count(*) as cnt from
    (
        select requester_id from requestaccepted
        union all
        select accepter_id from requestaccepted
    ) as tbl1
    group by requester_id
) as tbl2
order by cnt desc
limit 1