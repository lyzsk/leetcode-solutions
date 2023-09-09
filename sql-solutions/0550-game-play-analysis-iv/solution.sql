-- mysql
select round(count(distinct a1.player_id) / (select count(distinct player_id) from activity), 2) as fraction
from activity as a1, activity as a2
where a1.player_id = a2.player_id
and datediff(a1.event_date, a2.event_date) = 1
and (a2.player_id, a2.event_date) in
(
select player_id, min(event_date)
from activity
group by player_id
)