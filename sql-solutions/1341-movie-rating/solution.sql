-- mysql
(
    select users.name as results
    from movierating
    left join users
    on movierating.user_id = users.user_id
    group by users.name
    order by count(movierating.user_id) desc, users.name
    limit 1
)
union all
(
    select movies.title as results
    from movierating
    left join movies
    on movierating.movie_id = movies.movie_id
    where movierating.created_at >= '2020-02-01'
    and movierating.created_at < '2020-03-01'
    group by movies.title
    order by avg(movierating.rating) desc, movies.title
    limit 1
)