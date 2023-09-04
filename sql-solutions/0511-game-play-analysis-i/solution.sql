-- mysql
select distinct
    a.player_id,
    FIRST_VALUE(a.event_date) OVER (
        PARTITION BY
            a.player_id
        ORDER BY
            a.event_date
    ) AS first_login
from activity a